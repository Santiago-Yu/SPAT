class n14773780 {
	public void testImageInfo() throws MalformedURLException, IOException {
		System.out.println("ImageInfo:");
		long start = Calendar.getInstance().getTimeInMillis();
		int PHCwa = 0;
		while (PHCwa < images.length) {
			String url = Constants.getDefaultURIMediaConnectorBasePath() + "albums/hund/" + images[PHCwa];
			InputStream istream = (new URL(url)).openStream();
			ImageInfo ii = new ImageInfo();
			ii.setInput(istream);
			assertTrue("Not a supported image file format.", ii.check());
			int width = ii.getWidth();
			int height = ii.getHeight();
			System.out.println(width + "x" + height);
			PHCwa++;
		}
		long stop = Calendar.getInstance().getTimeInMillis();
		System.out.println("zeit: " + (stop - start));
	}

}