class n4254750 {
	protected static byte[] httpConnection(Context context, long token, String url, byte[] pdu, int method,
			boolean isProxySet, String proxyHost, int proxyPort) throws IOException {
		if (null == url) {
			throw new IllegalArgumentException("URL must not be null.");
		}
		if (LOCAL_LOGV) {
			Log.v(TAG, "httpConnection: params list");
			Log.v(TAG, "\ttoken\t\t= " + token);
			Log.v(TAG, "\turl\t\t= " + url);
			Log.v(TAG, "\tUser-Agent\t\t=" + mUserAgent);
			Log.v(TAG, "\tmethod\t\t= "
					+ ((HTTP_POST_METHOD == method) ? "POST" : ((HTTP_GET_METHOD == method) ? "GET" : "UNKNOWN")));
			Log.v(TAG, "\tisProxySet\t= " + isProxySet);
			Log.v(TAG, "\tproxyHost\t= " + proxyHost);
			Log.v(TAG, "\tproxyPort\t= " + proxyPort);
		}
		AndroidHttpClient client = null;
		try {
			URI hostUrl = new URI(url);
			HttpHost target = new HttpHost(hostUrl.getHost(), hostUrl.getPort(), HttpHost.DEFAULT_SCHEME_NAME);
			client = createHttpClient(context);
			HttpRequest req = null;
			switch (method) {
			case HTTP_POST_METHOD:
				ProgressCallbackEntity entity = new ProgressCallbackEntity(context, token, pdu);
				entity.setContentType("application/vnd.wap.mms-message");
				HttpPost post = new HttpPost(url);
				post.setEntity(entity);
				req = post;
				break;
			case HTTP_GET_METHOD:
				req = new HttpGet(url);
				break;
			default:
				Log.e(TAG, "Unknown HTTP method: " + method + ". Must be one of POST[" + HTTP_POST_METHOD + "] or GET["
						+ HTTP_GET_METHOD + "].");
				return null;
			}
			HttpParams params = client.getParams();
			if (isProxySet) {
				ConnRouteParams.setDefaultProxy(params, new HttpHost(proxyHost, proxyPort));
			}
			req.setParams(params);
			req.addHeader(HDR_KEY_ACCEPT, HDR_VALUE_ACCEPT);
			{
				String xWapProfileTagName = MmsConfig.getUaProfTagName();
				String xWapProfileUrl = MmsConfig.getUaProfUrl();
				if (xWapProfileUrl != null) {
					if (Log.isLoggable(LogTag.TRANSACTION, Log.VERBOSE)) {
						Log.d(LogTag.TRANSACTION, "[HttpUtils] httpConn: xWapProfUrl=" + xWapProfileUrl);
					}
					req.addHeader(xWapProfileTagName, xWapProfileUrl);
				}
			}
			String extraHttpParams = MmsConfig.getHttpParams();
			if (extraHttpParams != null) {
				String line1Number = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE))
						.getLine1Number();
				String line1Key = MmsConfig.getHttpParamsLine1Key();
				String paramList[] = extraHttpParams.split("\\|");
				for (String paramPair : paramList) {
					String splitPair[] = paramPair.split(":", 2);
					if (2 == splitPair.length) {
						String name = splitPair[0].trim();
						String value = splitPair[1].trim();
						if (line1Key != null) {
							value = value.replace(line1Key, line1Number);
						}
						if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(value)) {
							req.addHeader(name, value);
						}
					}
				}
			}
			req.addHeader(HDR_KEY_ACCEPT_LANGUAGE, HDR_VALUE_ACCEPT_LANGUAGE);
			HttpResponse response = client.execute(target, req);
			StatusLine status = response.getStatusLine();
			if (status.getStatusCode() != 200) {
				throw new IOException("HTTP error: " + status.getReasonPhrase());
			}
			HttpEntity entity = response.getEntity();
			byte[] body = null;
			if (entity != null) {
				try {
					if (entity.getContentLength() > 0) {
						body = new byte[(int) entity.getContentLength()];
						DataInputStream dis = new DataInputStream(entity.getContent());
						try {
							dis.readFully(body);
						} finally {
							try {
								dis.close();
							} catch (IOException e) {
								Log.e(TAG, "Error closing input stream: " + e.getMessage());
							}
						}
					}
				} finally {
					if (entity != null) {
						entity.consumeContent();
					}
				}
			}
			return body;
		} catch (URISyntaxException e) {
			handleHttpConnectionException(e, url);
		} catch (IllegalStateException e) {
			handleHttpConnectionException(e, url);
		} catch (IllegalArgumentException e) {
			handleHttpConnectionException(e, url);
		} catch (SocketException e) {
			handleHttpConnectionException(e, url);
		} catch (Exception e) {
			handleHttpConnectionException(e, url);
		} finally {
			if (client != null) {
				client.close();
			}
		}
		return null;
	}

}