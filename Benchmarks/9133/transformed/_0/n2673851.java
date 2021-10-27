class n2673851 {
	protected void initializeFromURL(URL eIfJcXtw) throws IOException {
		URLConnection YZkgaS4b = eIfJcXtw.openConnection();
		String DTbfkayM = this.validateURLConnection(YZkgaS4b, DBASE_CONTENT_TYPES);
		if (DTbfkayM != null) {
			throw new IOException(DTbfkayM);
		}
		this.channel = Channels.newChannel(WWIO.getBufferedInputStream(YZkgaS4b.getInputStream()));
		this.initialize();
	}

}