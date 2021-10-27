class n5280094 {
	public static URLConnection openRemoteDescriptionFile(String pFDNacm7) throws MalformedURLException {
		URL WUO7Qhv5 = new URL(pFDNacm7);
		try {
			URLConnection oZNvoWEs = WUO7Qhv5.openConnection();
			oZNvoWEs.connect();
			return oZNvoWEs;
		} catch (Exception t2UEs407) {
			Config D1ggzAPQ = Config.getInstance();
			SimpleSocketAddress RoTsC3zI = D1ggzAPQ.getLocalProxyServerAddress();
			Proxy iy5Fup95 = new Proxy(Type.HTTP, new InetSocketAddress(RoTsC3zI.host, RoTsC3zI.port));
			URLConnection mz6DW9Ij;
			try {
				mz6DW9Ij = WUO7Qhv5.openConnection(iy5Fup95);
				mz6DW9Ij.connect();
				return mz6DW9Ij;
			} catch (IOException UmkzFj4b) {
				logger.error("Failed to retrive desc file:" + WUO7Qhv5, UmkzFj4b);
			}
		}
		return null;
	}

}