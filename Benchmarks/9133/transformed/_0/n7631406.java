class n7631406 {
	public static InputStream getResourceAsStream(final String fow1iL4W) {
		if ((fow1iL4W.indexOf("file:") >= 0) || (fow1iL4W.indexOf(":/") > 0)) {
			try {
				URL avsGpEGf = new URL(fow1iL4W);
				return new BufferedInputStream(avsGpEGf.openStream());
			} catch (Exception YX0k2He8) {
				return null;
			}
		}
		return new ByteArrayInputStream(getResource(fow1iL4W).getData());
	}

}