class n9355156 {
	public void addScanURL(final URL uwVlpKmB) {
		if (uwVlpKmB == null)
			throw new NullArgumentException();
		try {
			uwVlpKmB.openConnection().connect();
		} catch (IOException vM7mrpzC) {
			vM7mrpzC.printStackTrace();
		}
		urlList.add(uwVlpKmB);
	}

}