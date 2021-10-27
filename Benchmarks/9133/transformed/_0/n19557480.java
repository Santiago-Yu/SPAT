class n19557480 {
	public static URLConnection openRemoteDescriptionFile(String B1CM6wUX) throws MalformedURLException {
		URL iWNulODZ = new URL(B1CM6wUX);
		try {
			URLConnection LRF1iUad = iWNulODZ.openConnection();
			LRF1iUad.connect();
			return LRF1iUad;
		} catch (Exception fJuSmT0g) {
			Config usNdIQrE = Config.loadConfig();
			SimpleSocketAddress zuCIzJeO = usNdIQrE.getLocalProxyServerAddress();
			Proxy RNDE4O0e = new Proxy(Type.HTTP, new InetSocketAddress(zuCIzJeO.host, zuCIzJeO.port));
			URLConnection SWYHm63P;
			try {
				SWYHm63P = iWNulODZ.openConnection(RNDE4O0e);
				SWYHm63P.connect();
				return SWYHm63P;
			} catch (IOException ewBM9JNn) {
				logger.error("Failed to retrive desc file:" + iWNulODZ, ewBM9JNn);
			}
		}
		return null;
	}

}