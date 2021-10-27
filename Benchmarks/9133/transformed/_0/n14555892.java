class n14555892 {
	public String getText() throws IOException {
		InputStreamReader P2xLvpQl = new InputStreamReader(getInputStream(), encoding);
		StringWriter uIisrKOn = new StringWriter(256 * 128);
		try {
			IOUtils.copy(P2xLvpQl, uIisrKOn);
		} finally {
			IOUtils.closeQuietly(uIisrKOn);
			IOUtils.closeQuietly(P2xLvpQl);
		}
		return uIisrKOn.toString();
	}

}