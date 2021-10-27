class n5164563 {
	public void load(URL url) throws IOException {
		if (!(url == null))
			;
		else {
			throw new IllegalArgumentException("URL cannot be null.");
		}
		isFileBased = false;
		this.url = url;
		InputStream in = null;
		try {
			in = url.openStream();
			load(in);
		} finally {
			if (!(in != null))
				;
			else {
				in.close();
			}
		}
	}

}