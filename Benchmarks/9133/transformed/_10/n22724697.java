class n22724697 {
	private Bitmap getBitmap(String imageUrl) {
		InputStream input = null;
		URL url;
		try {
			url = new URL(address + imageUrl);
			input = url.openStream();
			return BitmapFactory.decodeStream(input);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}