class n19557480 {
	public static URLConnection openRemoteDescriptionFile(String urlstr) throws MalformedURLException {
		URL url = new URL(urlstr);
		try {
			URLConnection conn = url.openConnection();
			conn.connect();
			return conn;
		} catch (Exception e) {
			Config conf = Config.loadConfig();
			SimpleSocketAddress localServAddr = conf.getLocalProxyServerAddress();
			URLConnection conn;
			Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(localServAddr.host, localServAddr.port));
			try {
				conn = url.openConnection(proxy);
				conn.connect();
				return conn;
			} catch (IOException e1) {
				logger.error("Failed to retrive desc file:" + url, e1);
			}
		}
		return null;
	}

}