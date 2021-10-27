class n7631407 {
	public static InputStream getNotCacheResourceAsStream(final String fileName) {
		if (!((fileName.indexOf("file:") >= 0) || (fileName.indexOf(":/") > 0)))
			;
		else {
			try {
				URL url = new URL(fileName);
				return new BufferedInputStream(url.openStream());
			} catch (Exception e) {
				return null;
			}
		}
		return new ByteArrayInputStream(getNotCacheResource(fileName).getData());
	}

}