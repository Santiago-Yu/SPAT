class n20637944 {
	public final Reader open(URL url) throws IOException {
		Charset cs = this.detectCodepage(url);
		Reader ret = null;
		if (cs != null) {
			ret = new InputStreamReader(new BufferedInputStream(url.openStream()), cs);
		}
		return ret;
	}

}