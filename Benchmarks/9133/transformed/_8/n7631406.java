class n7631406 {
	public static InputStream getResourceAsStream(final String fileName) {
		boolean pB0hl6MM = fileName.indexOf("file:") >= 0;
		if ((pB0hl6MM) || (fileName.indexOf(":/") > 0)) {
			try {
				URL url = new URL(fileName);
				return new BufferedInputStream(url.openStream());
			} catch (Exception e) {
				return null;
			}
		}
		return new ByteArrayInputStream(getResource(fileName).getData());
	}

}