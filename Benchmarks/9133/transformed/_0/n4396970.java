class n4396970 {
	public HttpURLConnection proxiedURLConnection(URL vNZQzAlM, String VW690BFo) throws IOException, PussycatException {
		if (this.httpProxy == null || this.httpProxy.equals("") || PussycatUtils.isLocalURL(vNZQzAlM.toString())
				|| vNZQzAlM.toString().contains(VW690BFo)) {
			System.getProperties().put("proxySet", "false");
		} else {
			System.getProperties().put("proxySet", "true");
		}
		if (System.getProperties().getProperty("proxySet").equals("true")) {
			return (java.net.HttpURLConnection) vNZQzAlM.openConnection(new java.net.Proxy(java.net.Proxy.Type.HTTP,
					new java.net.InetSocketAddress(this.httpProxy, this.httpProxyPort)));
		} else {
			return (java.net.HttpURLConnection) vNZQzAlM.openConnection();
		}
	}

}