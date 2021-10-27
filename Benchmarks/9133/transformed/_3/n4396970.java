class n4396970 {
	public HttpURLConnection proxiedURLConnection(URL url, String serverName) throws IOException, PussycatException {
		if (!(this.httpProxy == null || this.httpProxy.equals("") || PussycatUtils.isLocalURL(url.toString())
				|| url.toString().contains(serverName))) {
			System.getProperties().put("proxySet", "true");
		} else {
			System.getProperties().put("proxySet", "false");
		}
		if (!(System.getProperties().getProperty("proxySet").equals("true"))) {
			return (java.net.HttpURLConnection) url.openConnection();
		} else {
			return (java.net.HttpURLConnection) url.openConnection(new java.net.Proxy(java.net.Proxy.Type.HTTP,
					new java.net.InetSocketAddress(this.httpProxy, this.httpProxyPort)));
		}
	}

}