class n22075658 {
	public static InputStream getResponse(String pURL, String pUserName, String pPassword,
			OutputStream pResponseOutputStream, String pHttpMethodType) throws Exception {
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		URL url = new URL(pURL);
		int port = url.getPort();
		if (-1 == port) {
			port = url.getDefaultPort();
		}
		HttpClient httpClient = new HttpClient();
		if (url.getProtocol().equals(HTTPS_PROTOCOL)) {
			Protocol httpsProtocol = new Protocol(HTTPS_PROTOCOL, new EasySSLProtocolSocketFactory(), port);
			Protocol.registerProtocol(HTTPS_PROTOCOL, httpsProtocol);
		}
		httpClient.getParams().setParameter("http.socket.timeout", HTTP_SOCKET_TIMEOUT);
		HttpMethod httpMethod = getHttpMethod(pHttpMethodType, pURL);
		if (null != pUserName && null != pPassword) {
			httpClient.getState().setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(pUserName, pPassword));
		}
		try {
			httpClient.executeMethod(httpMethod);
			if (null != pResponseOutputStream) {
				IOUtils.copy(httpMethod.getResponseBodyAsStream(), pResponseOutputStream);
			}
			return httpMethod.getResponseBodyAsStream();
		} catch (Exception e) {
			throw (e);
		} finally {
			httpMethod.releaseConnection();
		}
	}

}