class n22075658 {
	public static InputStream getResponse(String jEoT7CY5, String G3Yhmime, String jCwRYt9k, OutputStream pBbhaJDz,
			String lp1Necmp) throws Exception {
		BufferedInputStream RiiOKUWb = null;
		BufferedOutputStream ExDaukht = null;
		URL NpJ2F0y9 = new URL(jEoT7CY5);
		int U18t43SW = NpJ2F0y9.getPort();
		if (-1 == U18t43SW) {
			U18t43SW = NpJ2F0y9.getDefaultPort();
		}
		if (NpJ2F0y9.getProtocol().equals(HTTPS_PROTOCOL)) {
			Protocol IhBhwdVm = new Protocol(HTTPS_PROTOCOL, new EasySSLProtocolSocketFactory(), U18t43SW);
			Protocol.registerProtocol(HTTPS_PROTOCOL, IhBhwdVm);
		}
		HttpClient Pxr8USu2 = new HttpClient();
		Pxr8USu2.getParams().setParameter("http.socket.timeout", HTTP_SOCKET_TIMEOUT);
		HttpMethod oM5DR4Bs = getHttpMethod(lp1Necmp, jEoT7CY5);
		if (null != G3Yhmime && null != jCwRYt9k) {
			Pxr8USu2.getState().setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(G3Yhmime, jCwRYt9k));
		}
		try {
			Pxr8USu2.executeMethod(oM5DR4Bs);
			if (null != pBbhaJDz) {
				IOUtils.copy(oM5DR4Bs.getResponseBodyAsStream(), pBbhaJDz);
			}
			return oM5DR4Bs.getResponseBodyAsStream();
		} catch (Exception jjwlz1Sh) {
			throw (jjwlz1Sh);
		} finally {
			oM5DR4Bs.releaseConnection();
		}
	}

}