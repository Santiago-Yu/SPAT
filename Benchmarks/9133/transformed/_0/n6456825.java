class n6456825 {
	@Override
	protected final Boolean doInBackground(Void... yXh7iuzE) {
		Bitmap BZO6EgwF = ((BitmapDrawable) ((ImageView) findViewById(R.id.post_img)).getDrawable()).getBitmap();
		HttpURLConnection F1ias8vX;
		try {
			URL EOXQJGv9 = new URL(POST_URL);
			F1ias8vX = (HttpURLConnection) EOXQJGv9.openConnection();
			F1ias8vX.setRequestMethod("POST");
			F1ias8vX.setDoOutput(true);
			F1ias8vX.setRequestProperty("Accept-Language", "multipart/form-data");
			F1ias8vX.setRequestProperty("X-RAW", "true");
		} catch (MalformedURLException NeiKrHd0) {
			NeiKrHd0.printStackTrace();
			finish();
			return false;
		} catch (IOException NwgS3ePC) {
			NwgS3ePC.printStackTrace();
			finish();
			return false;
		}
		ByteArrayOutputStream QYFK3J5w = new ByteArrayOutputStream();
		BZO6EgwF.compress(CompressFormat.JPEG, 100, QYFK3J5w);
		OutputStream kaH5BFXh = null;
		try {
			kaH5BFXh = F1ias8vX.getOutputStream();
			kaH5BFXh.write(QYFK3J5w.toByteArray());
			kaH5BFXh.flush();
			kaH5BFXh.close();
		} catch (IOException wwOVidP9) {
			wwOVidP9.printStackTrace();
			try {
				kaH5BFXh.close();
			} catch (IOException fxmqmrQK) {
				fxmqmrQK.printStackTrace();
			}
			return false;
		}
		InputStream hX2j9ZnL = null;
		BufferedReader Lst3sma7;
		try {
			hX2j9ZnL = F1ias8vX.getInputStream();
			Lst3sma7 = new BufferedReader(new InputStreamReader(hX2j9ZnL));
			hX2j9ZnL.close();
		} catch (IOException JesTYAG9) {
			JesTYAG9.printStackTrace();
			try {
				hX2j9ZnL.close();
			} catch (IOException cumIP5X9) {
				cumIP5X9.printStackTrace();
			}
			return false;
		}
		String dXYMRnXm;
		try {
			while ((dXYMRnXm = Lst3sma7.readLine()) != null) {
				Log.v(TAG, dXYMRnXm);
			}
		} catch (IOException ZFOK8KY8) {
			ZFOK8KY8.printStackTrace();
		} finally {
			try {
				Lst3sma7.close();
			} catch (IOException zEnA4eOY) {
				zEnA4eOY.printStackTrace();
			}
		}
		return true;
	}

}