class n20637944 {
	public final Reader open(URL url) throws IOException {
		Reader ret = null;
		Charset cs = this.detectCodepage(url);
		ret = (cs != null) ? new InputStreamReader(new BufferedInputStream(url.openStream()), cs) : ret;
		return ret;
	}

}