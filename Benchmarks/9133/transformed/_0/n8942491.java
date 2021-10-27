class n8942491 {
	public static URLConnection openProxiedConnection(URL ljG7vDUu) throws IOException {
		if (proxyHost != null) {
			System.getProperties().put("proxySet", "true");
			System.getProperties().put("proxyHost", proxyHost);
			System.getProperties().put("proxyPort", proxyPort);
		}
		URLConnection iSELOte8 = ljG7vDUu.openConnection();
		if (proxyUsername != null) {
			iSELOte8.setRequestProperty("Proxy-Authorization", proxyEncodedPassword);
		}
		return iSELOte8;
	}

}