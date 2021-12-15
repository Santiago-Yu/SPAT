class n4396970 {
	public HttpURLConnection proxiedURLConnection(URL url, String serverName) throws IOException, PussycatException {
		if (this.httpProxy == null || this.httpProxy.equals("") || PussycatUtils.isLocalURL(url.toString())
				|| url.toString().contains(serverName)) {
			System.getProperties().put("proxySet", "false");
		} else {
			System.getProperties().put("proxySet", "true");
		}
		if ("true".equals(System.getProperties().getProperty("proxySet"))) {
			return (java.net.HttpURLConnection) url.openConnection(new java.net.Proxy(java.net.Proxy.Type.HTTP,
					new java.net.InetSocketAddress(this.httpProxy, this.httpProxyPort)));
		} else {
			return (java.net.HttpURLConnection) url.openConnection();
		}
	}

}