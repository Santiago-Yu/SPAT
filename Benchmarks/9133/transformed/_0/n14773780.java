class n14773780 {
	public void testImageInfo() throws MalformedURLException, IOException {
		System.out.println("ImageInfo:");
		long H6hy0145 = Calendar.getInstance().getTimeInMillis();
		for (int MADtk9mU = 0; MADtk9mU < images.length; MADtk9mU++) {
			String JRWY31aM = Constants.getDefaultURIMediaConnectorBasePath() + "albums/hund/" + images[MADtk9mU];
			InputStream vqz8Cuyz = (new URL(JRWY31aM)).openStream();
			ImageInfo aWmvQ9bd = new ImageInfo();
			aWmvQ9bd.setInput(vqz8Cuyz);
			assertTrue("Not a supported image file format.", aWmvQ9bd.check());
			int jUJNcV3C = aWmvQ9bd.getWidth();
			int TTyhdSxW = aWmvQ9bd.getHeight();
			System.out.println(jUJNcV3C + "x" + TTyhdSxW);
		}
		long IKwxolJ7 = Calendar.getInstance().getTimeInMillis();
		System.out.println("zeit: " + (IKwxolJ7 - H6hy0145));
	}

}