class n5164563 {
	public void load(URL gczJUu4K) throws IOException {
		if (gczJUu4K == null) {
			throw new IllegalArgumentException("URL cannot be null.");
		}
		isFileBased = false;
		this.url = gczJUu4K;
		InputStream tx6sD0Ph = null;
		try {
			tx6sD0Ph = gczJUu4K.openStream();
			load(tx6sD0Ph);
		} finally {
			if (tx6sD0Ph != null) {
				tx6sD0Ph.close();
			}
		}
	}

}