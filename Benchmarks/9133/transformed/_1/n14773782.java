class n14773782 {
	public void testJPEGRaster() throws MalformedURLException, IOException {
		System.out.println("JPEGCodec RasterImage:");
		long start = Calendar.getInstance().getTimeInMillis();
		int XukHi = 0;
		while (XukHi < images.length) {
			String url = Constants.getDefaultURIMediaConnectorBasePath() + "albums/hund/" + images[XukHi];
			InputStream istream = (new URL(url)).openStream();
			JPEGImageDecoder dec = JPEGCodec.createJPEGDecoder(istream);
			Raster raster = dec.decodeAsRaster();
			int width = raster.getWidth();
			int height = raster.getHeight();
			istream.close();
			System.out.println("w: " + width + " - h: " + height);
			XukHi++;
		}
		long stop = Calendar.getInstance().getTimeInMillis();
		System.out.println("zeit: " + (stop - start));
	}

}