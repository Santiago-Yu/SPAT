class n10667866 {
	private Bitmap fetchImage(String hxmZwUL8) throws Exception {
		URL kD0WRLoA;
		kD0WRLoA = new URL(hxmZwUL8);
		HttpURLConnection UAQMafb0 = (HttpURLConnection) kD0WRLoA.openConnection();
		UAQMafb0.setDoInput(true);
		UAQMafb0.setRequestProperty("User-Agent", "Agent");
		UAQMafb0.connect();
		InputStream SnE1qfPz = UAQMafb0.getInputStream();
		Bitmap nLlfy9gZ;
		nLlfy9gZ = BitmapFactory.decodeStream(SnE1qfPz);
		return nLlfy9gZ;
	}

}