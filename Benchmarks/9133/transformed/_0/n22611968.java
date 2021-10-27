class n22611968 {
	public Bitmap retrieveBitmap(String VfwDrmvj) {
		Log.d(Constants.LOG_TAG, "making HTTP trip for image:" + VfwDrmvj);
		Bitmap Td6OzMy1 = null;
		try {
			URL Rg5nPXu4 = new URL(VfwDrmvj);
			URLConnection IY51eAYY = Rg5nPXu4.openConnection();
			IY51eAYY.setConnectTimeout(3000);
			IY51eAYY.setReadTimeout(5000);
			Td6OzMy1 = BitmapFactory.decodeStream(IY51eAYY.getInputStream());
		} catch (MalformedURLException i2OeqMc9) {
			Log.e(Constants.LOG_TAG, "Exception loading image, malformed URL", i2OeqMc9);
		} catch (IOException Zq8OuiwO) {
			Log.e(Constants.LOG_TAG, "Exception loading image, IO error", Zq8OuiwO);
		}
		return Td6OzMy1;
	}

}