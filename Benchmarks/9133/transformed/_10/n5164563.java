class n5164563 {
	public void load(URL url) throws IOException {
		isFileBased = false;
		if (url == null) {
			throw new IllegalArgumentException("URL cannot be null.");
		}
		InputStream in = null;
		this.url = url;
		try {
			in = url.openStream();
			load(in);
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

}