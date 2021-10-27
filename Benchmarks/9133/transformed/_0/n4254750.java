class n4254750 {
	protected static byte[] httpConnection(Context Sx3hlh6m, long KHkhufUh, String hPBoe4PT, byte[] Gnm7D98l,
			int Qs8avEtA, boolean Xyi6ITzG, String Jjp1osmF, int k3bJovKU) throws IOException {
		if (hPBoe4PT == null) {
			throw new IllegalArgumentException("URL must not be null.");
		}
		if (LOCAL_LOGV) {
			Log.v(TAG, "httpConnection: params list");
			Log.v(TAG, "\ttoken\t\t= " + KHkhufUh);
			Log.v(TAG, "\turl\t\t= " + hPBoe4PT);
			Log.v(TAG, "\tUser-Agent\t\t=" + mUserAgent);
			Log.v(TAG, "\tmethod\t\t= "
					+ ((Qs8avEtA == HTTP_POST_METHOD) ? "POST" : ((Qs8avEtA == HTTP_GET_METHOD) ? "GET" : "UNKNOWN")));
			Log.v(TAG, "\tisProxySet\t= " + Xyi6ITzG);
			Log.v(TAG, "\tproxyHost\t= " + Jjp1osmF);
			Log.v(TAG, "\tproxyPort\t= " + k3bJovKU);
		}
		AndroidHttpClient XgPBxxT0 = null;
		try {
			URI jQpI77A7 = new URI(hPBoe4PT);
			HttpHost feoAy99n = new HttpHost(jQpI77A7.getHost(), jQpI77A7.getPort(), HttpHost.DEFAULT_SCHEME_NAME);
			XgPBxxT0 = createHttpClient(Sx3hlh6m);
			HttpRequest FPxoH17w = null;
			switch (Qs8avEtA) {
			case HTTP_POST_METHOD:
				ProgressCallbackEntity r94h4hHr = new ProgressCallbackEntity(Sx3hlh6m, KHkhufUh, Gnm7D98l);
				r94h4hHr.setContentType("application/vnd.wap.mms-message");
				HttpPost dOXSFAtL = new HttpPost(hPBoe4PT);
				dOXSFAtL.setEntity(r94h4hHr);
				FPxoH17w = dOXSFAtL;
				break;
			case HTTP_GET_METHOD:
				FPxoH17w = new HttpGet(hPBoe4PT);
				break;
			default:
				Log.e(TAG, "Unknown HTTP method: " + Qs8avEtA + ". Must be one of POST[" + HTTP_POST_METHOD
						+ "] or GET[" + HTTP_GET_METHOD + "].");
				return null;
			}
			HttpParams QPQY6TFo = XgPBxxT0.getParams();
			if (Xyi6ITzG) {
				ConnRouteParams.setDefaultProxy(QPQY6TFo, new HttpHost(Jjp1osmF, k3bJovKU));
			}
			FPxoH17w.setParams(QPQY6TFo);
			FPxoH17w.addHeader(HDR_KEY_ACCEPT, HDR_VALUE_ACCEPT);
			{
				String CSMVIhMb = MmsConfig.getUaProfTagName();
				String uebfGd5a = MmsConfig.getUaProfUrl();
				if (uebfGd5a != null) {
					if (Log.isLoggable(LogTag.TRANSACTION, Log.VERBOSE)) {
						Log.d(LogTag.TRANSACTION, "[HttpUtils] httpConn: xWapProfUrl=" + uebfGd5a);
					}
					FPxoH17w.addHeader(CSMVIhMb, uebfGd5a);
				}
			}
			String Xzm8jxk1 = MmsConfig.getHttpParams();
			if (Xzm8jxk1 != null) {
				String GWaGUE42 = ((TelephonyManager) Sx3hlh6m.getSystemService(Context.TELEPHONY_SERVICE))
						.getLine1Number();
				String Xthdlh3I = MmsConfig.getHttpParamsLine1Key();
				String Fprk7uwR[] = Xzm8jxk1.split("\\|");
				for (String O8qdZrdZ : Fprk7uwR) {
					String LqC2JpyM[] = O8qdZrdZ.split(":", 2);
					if (LqC2JpyM.length == 2) {
						String f4MpA3qC = LqC2JpyM[0].trim();
						String YCeeS7ns = LqC2JpyM[1].trim();
						if (Xthdlh3I != null) {
							YCeeS7ns = YCeeS7ns.replace(Xthdlh3I, GWaGUE42);
						}
						if (!TextUtils.isEmpty(f4MpA3qC) && !TextUtils.isEmpty(YCeeS7ns)) {
							FPxoH17w.addHeader(f4MpA3qC, YCeeS7ns);
						}
					}
				}
			}
			FPxoH17w.addHeader(HDR_KEY_ACCEPT_LANGUAGE, HDR_VALUE_ACCEPT_LANGUAGE);
			HttpResponse U8vEwsZ8 = XgPBxxT0.execute(feoAy99n, FPxoH17w);
			StatusLine hHiehMB3 = U8vEwsZ8.getStatusLine();
			if (hHiehMB3.getStatusCode() != 200) {
				throw new IOException("HTTP error: " + hHiehMB3.getReasonPhrase());
			}
			HttpEntity gLXixSe5 = U8vEwsZ8.getEntity();
			byte[] cLphlVQT = null;
			if (gLXixSe5 != null) {
				try {
					if (gLXixSe5.getContentLength() > 0) {
						cLphlVQT = new byte[(int) gLXixSe5.getContentLength()];
						DataInputStream MmtKWnoi = new DataInputStream(gLXixSe5.getContent());
						try {
							MmtKWnoi.readFully(cLphlVQT);
						} finally {
							try {
								MmtKWnoi.close();
							} catch (IOException BkGXOolH) {
								Log.e(TAG, "Error closing input stream: " + BkGXOolH.getMessage());
							}
						}
					}
				} finally {
					if (gLXixSe5 != null) {
						gLXixSe5.consumeContent();
					}
				}
			}
			return cLphlVQT;
		} catch (URISyntaxException xKX90s5k) {
			handleHttpConnectionException(xKX90s5k, hPBoe4PT);
		} catch (IllegalStateException yKyQZfe1) {
			handleHttpConnectionException(yKyQZfe1, hPBoe4PT);
		} catch (IllegalArgumentException jwdZF8dh) {
			handleHttpConnectionException(jwdZF8dh, hPBoe4PT);
		} catch (SocketException F2EPN5EJ) {
			handleHttpConnectionException(F2EPN5EJ, hPBoe4PT);
		} catch (Exception ZuibKGLH) {
			handleHttpConnectionException(ZuibKGLH, hPBoe4PT);
		} finally {
			if (XgPBxxT0 != null) {
				XgPBxxT0.close();
			}
		}
		return null;
	}

}