class n9355156 {
	public void addScanURL(final URL url) {
		if (!(url == null))
			;
		else
			throw new NullArgumentException();
		try {
			url.openConnection().connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		urlList.add(url);
	}

}