class n14759460 {
	public static final Bitmap getBitmap(final String key, int size) {
		byte[] line = new byte[1024];
		Bitmap bmp = null;
		String urlStr = URI_IMAGE + key;
		int byteSize = 0;
		try {
			URL url = new URL(urlStr);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.connect();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			InputStream is = con.getInputStream();
			BitmapFactory.Options options = new BitmapFactory.Options();
			while ((byteSize = is.read(line)) > 0) {
				out.write(line, 0, byteSize);
			}
			options.inSampleSize = size;
			byte[] byteArray = out.toByteArray();
			bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bmp;
	}

}