class n14773781 {
	public void testJPEGBuffImage() throws MalformedURLException, IOException {
		System.out.println("JPEGCodec BufferedImage:");
		long mewCsAX3 = Calendar.getInstance().getTimeInMillis();
		for (int XTFqq367 = 0; XTFqq367 < images.length; XTFqq367++) {
			String cGE3MgO0 = Constants.getDefaultURIMediaConnectorBasePath() + "albums/hund/" + images[XTFqq367];
			InputStream xp6AGo1U = (new URL(cGE3MgO0)).openStream();
			JPEGImageDecoder txMudQis = JPEGCodec.createJPEGDecoder(xp6AGo1U);
			BufferedImage x2dMQihw = txMudQis.decodeAsBufferedImage();
			int AafN5Pgm = x2dMQihw.getWidth();
			int Lqr0Q6uo = x2dMQihw.getHeight();
			xp6AGo1U.close();
			System.out.println("w: " + AafN5Pgm + " - h: " + Lqr0Q6uo);
		}
		long t50ZSULl = Calendar.getInstance().getTimeInMillis();
		System.out.println("zeit: " + (t50ZSULl - mewCsAX3));
	}

}