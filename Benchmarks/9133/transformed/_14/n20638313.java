class n20638313 {
	public void init() throws IOException {
		if (null == this.inputStream)
			this.inputStream = new BufferedInputStream(url.openStream());
		else {
			this.inputStream.close();
			this.inputStream = new BufferedInputStream(url.openStream());
		}
	}

}