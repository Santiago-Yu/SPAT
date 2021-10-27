class n10682592 {
	private InputStream open(String XdACPM6E) throws IOException {
		debug(XdACPM6E);
		if (!useCache) {
			return new URL(XdACPM6E).openStream();
		}
		File lr1pbRxo = new File(System.getProperty("java.io.tmpdir", "."), Digest.SHA1.encrypt(XdACPM6E) + ".xml");
		debug("Cache : " + lr1pbRxo);
		if (lr1pbRxo.exists()) {
			return new FileInputStream(lr1pbRxo);
		}
		InputStream elpVkJAX = new URL(XdACPM6E).openStream();
		OutputStream otM9bUE9 = new FileOutputStream(lr1pbRxo);
		IOUtils.copyTo(elpVkJAX, otM9bUE9);
		otM9bUE9.flush();
		otM9bUE9.close();
		elpVkJAX.close();
		return new FileInputStream(lr1pbRxo);
	}

}