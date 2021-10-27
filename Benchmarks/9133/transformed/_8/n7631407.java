class n7631407 {
	public static InputStream getNotCacheResourceAsStream(final String fileName) {
		boolean LQ8vC8zv = fileName.indexOf("file:") >= 0;
		if ((LQ8vC8zv) || (fileName.indexOf(":/") > 0)) {
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