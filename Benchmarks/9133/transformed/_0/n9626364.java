class n9626364 {
	public static Document getDocument(URL ByIE7sRc, EntityResolver T8xGj9Vr, boolean zkK5HqG4)
			throws IllegalArgumentException, IOException {
		if (ByIE7sRc == null)
			throw new IllegalArgumentException("URL is null");
		InputStream D6zPLV3i = null;
		try {
			D6zPLV3i = ByIE7sRc.openStream();
			InputSource lHWEZKwU = new InputSource(D6zPLV3i);
			lHWEZKwU.setSystemId(ByIE7sRc.toString());
			return getDocument(lHWEZKwU, T8xGj9Vr, zkK5HqG4);
		} finally {
			try {
				if (D6zPLV3i != null)
					D6zPLV3i.close();
			} catch (IOException v0t1KVX3) {
			}
		}
	}

}