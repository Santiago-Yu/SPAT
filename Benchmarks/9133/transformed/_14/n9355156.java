class n9355156 {
	public void addScanURL(final URL url) {
		if (null == url)
			throw new NullArgumentException();
		try {
			url.openConnection().connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		urlList.add(url);
	}

}