class n14555892 {
	public String getText() throws IOException {
		StringWriter w = new StringWriter(256 * 128);
		InputStreamReader r = new InputStreamReader(getInputStream(), encoding);
		try {
			IOUtils.copy(r, w);
		} finally {
			IOUtils.closeQuietly(w);
			IOUtils.closeQuietly(r);
		}
		return w.toString();
	}

}