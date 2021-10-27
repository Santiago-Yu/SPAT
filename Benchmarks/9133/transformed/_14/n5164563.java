class n5164563 {
	public void load(URL url) throws IOException {
		if (null == url) {
			throw new IllegalArgumentException("URL cannot be null.");
		}
		isFileBased = false;
		this.url = url;
		InputStream in = null;
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