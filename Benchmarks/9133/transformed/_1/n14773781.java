class n14773781 {
	public void testJPEGBuffImage() throws MalformedURLException, IOException {
		System.out.println("JPEGCodec BufferedImage:");
		long start = Calendar.getInstance().getTimeInMillis();
		int AKblU = 0;
		while (AKblU < images.length) {
			String url = Constants.getDefaultURIMediaConnectorBasePath() + "albums/hund/" + images[AKblU];
			InputStream istream = (new URL(url)).openStream();
			JPEGImageDecoder dec = JPEGCodec.createJPEGDecoder(istream);
			BufferedImage image = dec.decodeAsBufferedImage();
			int width = image.getWidth();
			int height = image.getHeight();
			istream.close();
			System.out.println("w: " + width + " - h: " + height);
			AKblU++;
		}
		long stop = Calendar.getInstance().getTimeInMillis();
		System.out.println("zeit: " + (stop - start));
	}

}