class n13667527 {
	private Bitmap fetchImage(String qsaEUTg1) throws Exception {
		URL YhDrSV0J;
		YhDrSV0J = new URL(qsaEUTg1);
		HttpURLConnection osRVkFp7 = (HttpURLConnection) YhDrSV0J.openConnection();
		osRVkFp7.setDoInput(true);
		osRVkFp7.setRequestProperty("User-Agent", "Agent");
		osRVkFp7.connect();
		InputStream oNed8eJy = osRVkFp7.getInputStream();
		Bitmap rzljJd5c;
		rzljJd5c = BitmapFactory.decodeStream(oNed8eJy);
		return rzljJd5c;
	}

}