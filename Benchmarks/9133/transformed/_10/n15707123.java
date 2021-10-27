class n15707123 {
	private Bitmap fetchImage(String urlstr) throws Exception {
		URL url;
		url = new URL(urlstr);
		HttpURLConnection c = (HttpURLConnection) url.openConnection();
		c.setDoInput(true);
		c.setRequestProperty("User-Agent", "Agent");
		c.connect();
		Bitmap img;
		InputStream is = c.getInputStream();
		img = BitmapFactory.decodeStream(is);
		return img;
	}

}