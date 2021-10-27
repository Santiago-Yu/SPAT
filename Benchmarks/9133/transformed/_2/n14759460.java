class n14759460 {
	public static final Bitmap getBitmap(final String key, int size) {
		Bitmap bmp = null;
		byte[] line = new byte[1024];
		int byteSize = 0;
		String urlStr = URI_IMAGE + key;
		try {
			URL url = new URL(urlStr);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.connect();
			InputStream is = con.getInputStream();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			for (; (byteSize = is.read(line)) > 0;) {
				out.write(line, 0, byteSize);
			}
			BitmapFactory.Options options = new BitmapFactory.Options();
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