class n14773782 {
	public void testJPEGRaster() throws MalformedURLException, IOException {
		System.out.println("JPEGCodec RasterImage:");
		long pabFHvUJ = Calendar.getInstance().getTimeInMillis();
		for (int wWFjd90j = 0; wWFjd90j < images.length; wWFjd90j++) {
			String nvwDdVDC = Constants.getDefaultURIMediaConnectorBasePath() + "albums/hund/" + images[wWFjd90j];
			InputStream uEz4Nzu4 = (new URL(nvwDdVDC)).openStream();
			JPEGImageDecoder KcxL55gc = JPEGCodec.createJPEGDecoder(uEz4Nzu4);
			Raster rV0kC1Pg = KcxL55gc.decodeAsRaster();
			int hdX0HKmd = rV0kC1Pg.getWidth();
			int MEZ4ZEvN = rV0kC1Pg.getHeight();
			uEz4Nzu4.close();
			System.out.println("w: " + hdX0HKmd + " - h: " + MEZ4ZEvN);
		}
		long FOSCO6oz = Calendar.getInstance().getTimeInMillis();
		System.out.println("zeit: " + (FOSCO6oz - pabFHvUJ));
	}

}