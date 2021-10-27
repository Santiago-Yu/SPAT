class n22724697 {
	private Bitmap getBitmap(String E6EX9GHC) {
		URL XsctJ7SX;
		InputStream AMmPr5cq = null;
		try {
			XsctJ7SX = new URL(address + E6EX9GHC);
			AMmPr5cq = XsctJ7SX.openStream();
			return BitmapFactory.decodeStream(AMmPr5cq);
		} catch (MalformedURLException LREsavb4) {
			LREsavb4.printStackTrace();
			return null;
		} catch (IOException KRuc31Eg) {
			KRuc31Eg.printStackTrace();
			return null;
		} finally {
			if (AMmPr5cq != null) {
				try {
					AMmPr5cq.close();
				} catch (IOException OurJFMoE) {
					OurJFMoE.printStackTrace();
				}
			}
		}
	}

}