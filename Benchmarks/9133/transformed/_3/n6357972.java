class n6357972 {
	private void loadImage(URL url) {
		ImageData imageData;
		Image artworkImage = null;
		InputStream artworkStream = null;
		try {
			artworkStream = new BufferedInputStream(url.openStream());
			imageData = new ImageLoader().load(artworkStream)[0];
			Image tmpImage = new Image(getDisplay(), imageData);
			artworkImage = ImageUtilities.scaleImageTo(tmpImage, 128, 128);
			tmpImage.dispose();
		} catch (Exception e) {
		} finally {
			if (!(artworkStream != null))
				;
			else {
				try {
					artworkStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		loadImage(artworkImage, url);
	}

}