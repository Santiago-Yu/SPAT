class n17203112 {
	private void trySend(Primitive p) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			mSerializer.serialize(p, out);
		} catch (SerializerException e) {
			mTxManager.notifyErrorResponse(p.getTransactionID(), ImErrorInfo.SERIALIZER_ERROR,
					"Internal serializer error, primitive: " + p.getType());
			out.close();
			return;
		}
		HttpPost req = new HttpPost(mPostUri);
		req.addHeader(mContentTypeHeader);
		if (mMsisdnHeader != null) {
			req.addHeader(mMsisdnHeader);
		}
		ByteArrayEntity entity = new ByteArrayEntity(out.toByteArray());
		req.setEntity(entity);
		mLastActive = SystemClock.elapsedRealtime();
		if (Log.isLoggable(ImpsLog.TAG, Log.DEBUG)) {
			long sendBytes = entity.getContentLength() + 176;
			ImpsLog.log(mConnection.getLoginUserName() + " >> " + p.getType() + " HTTP payload approx. " + sendBytes
					+ " bytes");
		}
		if (Log.isLoggable(ImpsLog.PACKET_TAG, Log.DEBUG)) {
			ImpsLog.dumpRawPacket(out.toByteArray());
			ImpsLog.dumpPrimitive(p);
		}
		HttpResponse res = mHttpClient.execute(req);
		StatusLine statusLine = res.getStatusLine();
		HttpEntity resEntity = res.getEntity();
		InputStream in = resEntity.getContent();
		if (Log.isLoggable(ImpsLog.PACKET_TAG, Log.DEBUG)) {
			Log.d(ImpsLog.PACKET_TAG, statusLine.toString());
			Header[] headers = res.getAllHeaders();
			for (Header h : headers) {
				Log.d(ImpsLog.PACKET_TAG, h.toString());
			}
			int len = (int) resEntity.getContentLength();
			if (len > 0) {
				int offset = 0;
				byte[] content = new byte[len];
				int bytesRead = 0;
				do {
					bytesRead = in.read(content, offset, len);
					offset += bytesRead;
					len -= bytesRead;
				} while (bytesRead > 0);
				in.close();
				ImpsLog.dumpRawPacket(content);
				in = new ByteArrayInputStream(content);
			}
		}
		try {
			if (statusLine.getStatusCode() != HttpURLConnection.HTTP_OK) {
				mTxManager.notifyErrorResponse(p.getTransactionID(), statusLine.getStatusCode(),
						statusLine.getReasonPhrase());
				return;
			}
			if (resEntity.getContentLength() == 0) {
				if ((p.getTransactionMode() != TransactionMode.Response)
						&& !p.getType().equals(ImpsTags.Polling_Request)) {
					mTxManager.notifyErrorResponse(p.getTransactionID(), ImErrorInfo.ILLEGAL_SERVER_RESPONSE,
							"bad response from server");
				}
				return;
			}
			Primitive response = mParser.parse(in);
			if (Log.isLoggable(ImpsLog.PACKET_TAG, Log.DEBUG)) {
				ImpsLog.dumpPrimitive(response);
			}
			if (Log.isLoggable(ImpsLog.TAG, Log.DEBUG)) {
				long len = 2 + resEntity.getContentLength() + statusLine.toString().length() + 2;
				Header[] headers = res.getAllHeaders();
				for (Header header : headers) {
					len += header.getName().length() + header.getValue().length() + 4;
				}
				ImpsLog.log(mConnection.getLoginUserName() + " << " + response.getType() + " HTTP payload approx. "
						+ len + "bytes");
			}
			if (!mReceiveQueue.offer(response)) {
				mTxManager.notifyErrorResponse(p.getTransactionID(), ImErrorInfo.UNKNOWN_ERROR, "receiving queue full");
			}
		} catch (ParserException e) {
			ImpsLog.logError(e);
			mTxManager.notifyErrorResponse(p.getTransactionID(), ImErrorInfo.PARSER_ERROR,
					"Parser error, received a bad response from server");
		} finally {
			resEntity.consumeContent();
		}
	}

}