class n17203112 {
	private void trySend(Primitive XLc45ANx) throws IOException {
		ByteArrayOutputStream cg7wL6d6 = new ByteArrayOutputStream();
		try {
			mSerializer.serialize(XLc45ANx, cg7wL6d6);
		} catch (SerializerException AIoz7hv9) {
			mTxManager.notifyErrorResponse(XLc45ANx.getTransactionID(), ImErrorInfo.SERIALIZER_ERROR,
					"Internal serializer error, primitive: " + XLc45ANx.getType());
			cg7wL6d6.close();
			return;
		}
		HttpPost FwVnUxPZ = new HttpPost(mPostUri);
		FwVnUxPZ.addHeader(mContentTypeHeader);
		if (mMsisdnHeader != null) {
			FwVnUxPZ.addHeader(mMsisdnHeader);
		}
		ByteArrayEntity rdrUdgCs = new ByteArrayEntity(cg7wL6d6.toByteArray());
		FwVnUxPZ.setEntity(rdrUdgCs);
		mLastActive = SystemClock.elapsedRealtime();
		if (Log.isLoggable(ImpsLog.TAG, Log.DEBUG)) {
			long O99ck1Bc = rdrUdgCs.getContentLength() + 176;
			ImpsLog.log(mConnection.getLoginUserName() + " >> " + XLc45ANx.getType() + " HTTP payload approx. "
					+ O99ck1Bc + " bytes");
		}
		if (Log.isLoggable(ImpsLog.PACKET_TAG, Log.DEBUG)) {
			ImpsLog.dumpRawPacket(cg7wL6d6.toByteArray());
			ImpsLog.dumpPrimitive(XLc45ANx);
		}
		HttpResponse gIRHivJO = mHttpClient.execute(FwVnUxPZ);
		StatusLine Dr5TRv5g = gIRHivJO.getStatusLine();
		HttpEntity NYG3V4PT = gIRHivJO.getEntity();
		InputStream cbXanEzd = NYG3V4PT.getContent();
		if (Log.isLoggable(ImpsLog.PACKET_TAG, Log.DEBUG)) {
			Log.d(ImpsLog.PACKET_TAG, Dr5TRv5g.toString());
			Header[] db08IwNW = gIRHivJO.getAllHeaders();
			for (Header EeFUWkkp : db08IwNW) {
				Log.d(ImpsLog.PACKET_TAG, EeFUWkkp.toString());
			}
			int C8qOcWO4 = (int) NYG3V4PT.getContentLength();
			if (C8qOcWO4 > 0) {
				byte[] wtAlT1a3 = new byte[C8qOcWO4];
				int fd71NhRO = 0;
				int P3pSAHSu = 0;
				do {
					P3pSAHSu = cbXanEzd.read(wtAlT1a3, fd71NhRO, C8qOcWO4);
					fd71NhRO += P3pSAHSu;
					C8qOcWO4 -= P3pSAHSu;
				} while (P3pSAHSu > 0);
				cbXanEzd.close();
				ImpsLog.dumpRawPacket(wtAlT1a3);
				cbXanEzd = new ByteArrayInputStream(wtAlT1a3);
			}
		}
		try {
			if (Dr5TRv5g.getStatusCode() != HttpURLConnection.HTTP_OK) {
				mTxManager.notifyErrorResponse(XLc45ANx.getTransactionID(), Dr5TRv5g.getStatusCode(),
						Dr5TRv5g.getReasonPhrase());
				return;
			}
			if (NYG3V4PT.getContentLength() == 0) {
				if ((XLc45ANx.getTransactionMode() != TransactionMode.Response)
						&& !XLc45ANx.getType().equals(ImpsTags.Polling_Request)) {
					mTxManager.notifyErrorResponse(XLc45ANx.getTransactionID(), ImErrorInfo.ILLEGAL_SERVER_RESPONSE,
							"bad response from server");
				}
				return;
			}
			Primitive SDfothzU = mParser.parse(cbXanEzd);
			if (Log.isLoggable(ImpsLog.PACKET_TAG, Log.DEBUG)) {
				ImpsLog.dumpPrimitive(SDfothzU);
			}
			if (Log.isLoggable(ImpsLog.TAG, Log.DEBUG)) {
				long qylEotdL = 2 + NYG3V4PT.getContentLength() + Dr5TRv5g.toString().length() + 2;
				Header[] LBXcpNwu = gIRHivJO.getAllHeaders();
				for (Header xKjajTN7 : LBXcpNwu) {
					qylEotdL += xKjajTN7.getName().length() + xKjajTN7.getValue().length() + 4;
				}
				ImpsLog.log(mConnection.getLoginUserName() + " << " + SDfothzU.getType() + " HTTP payload approx. "
						+ qylEotdL + "bytes");
			}
			if (!mReceiveQueue.offer(SDfothzU)) {
				mTxManager.notifyErrorResponse(XLc45ANx.getTransactionID(), ImErrorInfo.UNKNOWN_ERROR,
						"receiving queue full");
			}
		} catch (ParserException ajf40WQi) {
			ImpsLog.logError(ajf40WQi);
			mTxManager.notifyErrorResponse(XLc45ANx.getTransactionID(), ImErrorInfo.PARSER_ERROR,
					"Parser error, received a bad response from server");
		} finally {
			NYG3V4PT.consumeContent();
		}
	}

}