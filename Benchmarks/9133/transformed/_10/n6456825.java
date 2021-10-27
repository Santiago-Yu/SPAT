class n6456825 {
	@Override
	protected final Boolean doInBackground(Void... v) {
		HttpURLConnection con;
		Bitmap bmp = ((BitmapDrawable) ((ImageView) findViewById(R.id.post_img)).getDrawable()).getBitmap();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			URL url = new URL(POST_URL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.setRequestProperty("Accept-Language", "multipart/form-data");
			con.setRequestProperty("X-RAW", "true");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			finish();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			finish();
			return false;
		}
		bmp.compress(CompressFormat.JPEG, 100, bos);
		OutputStream os = null;
		InputStream is = null;
		try {
			os = con.getOutputStream();
			os.write(bos.toByteArray());
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
			try {
				os.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		BufferedReader reader;
		String s;
		try {
			is = con.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is));
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
			try {
				is.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		try {
			while ((s = reader.readLine()) != null) {
				Log.v(TAG, s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

}