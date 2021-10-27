class n6357972 {
	private void loadImage(URL EZEi35oe) {
		ImageData oadh7jME;
		Image h6VoPi77 = null;
		InputStream KtQQEt5O = null;
		try {
			KtQQEt5O = new BufferedInputStream(EZEi35oe.openStream());
			oadh7jME = new ImageLoader().load(KtQQEt5O)[0];
			Image ehKgVQ9T = new Image(getDisplay(), oadh7jME);
			h6VoPi77 = ImageUtilities.scaleImageTo(ehKgVQ9T, 128, 128);
			ehKgVQ9T.dispose();
		} catch (Exception x4wUDUuE) {
		} finally {
			if (KtQQEt5O != null) {
				try {
					KtQQEt5O.close();
				} catch (IOException caijeYQB) {
					caijeYQB.printStackTrace();
				}
			}
		}
		loadImage(h6VoPi77, EZEi35oe);
	}

}