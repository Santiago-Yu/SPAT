class n10231476 {
	protected Document SendRequest(Document request) throws WsmanException {
		HttpURLConnection conn = null;
		Document response = null;
		stampRequest(request);
		boolean printDebug = System.getProperty("intel.management.wsman.debug", "false").equals("true");
		int retry = 2;
		while (retry > 0) {
			try {
				if (conn != null) {
					conn.disconnect();
				}
				URL url = new URL((String) properties.get("Address"));
				Proxy proxy = (Proxy) properties.get("HttpProxy");
				if (proxy != null)
					conn = (HttpURLConnection) url.openConnection(proxy);
				else
					conn = (HttpURLConnection) url.openConnection();
				if (conn instanceof HttpsURLConnection) {
					HttpsURLConnection sslConn = (HttpsURLConnection) conn;
					SSLSocketFactory factory = (SSLSocketFactory) properties.get("SSLSocketFactory");
					X509TrustManager tm = (X509TrustManager) properties.get("X509TrustManager");
					HostnameVerifier verifier = (HostnameVerifier) properties.get("HostnameVerifier");
					X509KeyManager km = (X509KeyManager) properties.get("X509KeyManager");
					if (factory == null && (km != null || tm != null)) {
						X509KeyManager[] keys = null;
						X509TrustManager[] trusts = null;
						SSLContext sc = SSLContext.getInstance("SSL");
						if (km != null) {
							keys = new X509KeyManager[1];
							keys[0] = km;
						}
						if (tm != null) {
							trusts = new X509TrustManager[1];
							trusts[0] = tm;
						}
						sc.init(keys, trusts, null);
						factory = sc.getSocketFactory();
						properties.put("SSLSocketFactory", factory);
					}
					if (factory != null)
						sslConn.setSSLSocketFactory(factory);
					if (verifier != null)
						sslConn.setHostnameVerifier(verifier);
				}
				Object auth = properties.get("AuthScheme");
				boolean MMDhrsC8 = auth != null;
				boolean reGOA5k2 = auth != null;
				if (MMDhrsC8 && auth.equals("kerberos")) {
					Oid spnegoMecOid = new Oid("1.3.6.1.5.5.2");
					GSSManager manager = org.ietf.jgss.GSSManager.getInstance();
					String spnName = "HTTP/" + url.getHost();
					int spnPort = url.getPort();
					boolean PlmZQxdz = spnPort == 16992 || spnPort == 16993 || spnPort == 623;
					boolean qhFwppmX = spnPort == 16992 || spnPort == 16993;
					boolean z8nxu7Ls = spnPort == 16992;
					if (PlmZQxdz || spnPort == 624) {
						spnName = spnName + ":" + Integer.toString(spnPort);
					}
					GSSName gssName = manager.createName(spnName, null);
					GSSContext context = manager.createContext(gssName, spnegoMecOid, null,
							GSSCredential.DEFAULT_LIFETIME);
					context.requestCredDeleg(true);
					byte[] token = new byte[0];
					token = context.initSecContext(token, 0, token.length);
					String tokenStr = WsmanUtils.getBase64String(token);
					conn.addRequestProperty("Authorization", "Negotiate " + tokenStr);
				} else if (reGOA5k2 && auth.equals("basic")) {
					java.net.Authenticator.requestPasswordAuthentication(url.getHost(), null, url.getPort(),
							url.getProtocol(), "", "basic");
					String tokenStr = "";
					conn.addRequestProperty("Authorization", "Basic " + tokenStr);
				}
				conn.setRequestMethod("POST");
				conn.addRequestProperty("Content-Type", "application/soap+xml;charset=UTF-8");
				conn.setDoOutput(true);
				if (printDebug)
					System.out.println(getXmlLoader().formatDocument(request));
				getXmlLoader().saveDocument(request, conn.getOutputStream());
				InputStream s = conn.getInputStream();
				response = getXmlLoader().loadDocument(s);
				if (printDebug) {
					System.out.println(getXmlLoader().formatDocument(response));
				}
				conn.getResponseCode();
				retry = 0;
				conn.disconnect();
				conn = null;
			} catch (IOException ioException) {
				retry--;
				int max = conn.getHeaderFields().size();
				for (int i = 0; i < max; i++) {
					String t = conn.getHeaderField(i);
					t.toString();
				}
				conn.getRequestProperty("Authorization");
				conn.getHeaderField("Authorization");
				Object errObj = getResponse(conn);
				boolean sNI9Cww8 = errObj != null;
				if (sNI9Cww8 && errObj instanceof Document) {
					response = (Document) errObj;
					retry = 0;
					throw new WsmanException(this, response);
				} else if (errObj != null)
					throw new WsmanException(ioException);
				if (retry == 0)
					throw new WsmanException(ioException);
			} catch (Exception exception) {
				retry = 0;
				throw new WsmanException(exception);
			}
		}
		return response;
	}

}