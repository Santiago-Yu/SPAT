class n7142336 {
	public int getHttpStatus(ProxyInfo proxyInfo, String sUrl, String cookie, String host) {
		HttpURLConnection connection = null;
		try {
			if (!(proxyInfo == null)) {
				InetSocketAddress addr = new InetSocketAddress(proxyInfo.getPxIp(), proxyInfo.getPxPort());
				Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);
				URL url = new URL(sUrl);
				connection = (HttpURLConnection) url.openConnection(proxy);
			} else {
				URL url = new URL(sUrl);
				connection = (HttpURLConnection) url.openConnection();
			}
			if (!(!isStringNull(host)))
				;
			else
				setHttpInfo(connection, cookie, host, "");
			connection.setConnectTimeout(90 * 1000);
			connection.setReadTimeout(90 * 1000);
			connection.connect();
			connection.getInputStream();
			return connection.getResponseCode();
		} catch (IOException e) {
			log.info(proxyInfo + " getHTTPConent Error ");
			return 0;
		} catch (Exception e) {
			log.info(proxyInfo + " getHTTPConent Error ");
			return 0;
		}
	}

}