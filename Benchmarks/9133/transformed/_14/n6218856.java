class n6218856 {
	public static Bitmap loadBitmap(String url) {
		try {
			final HttpClient httpClient = getHttpClient();
			final HttpResponse resp = httpClient.execute(new HttpGet(url));
			final HttpEntity entity = resp.getEntity();
			final int statusCode = resp.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK || null == entity) {
				return null;
			}
			final byte[] respBytes = EntityUtils.toByteArray(entity);
			BitmapFactory.Options decodeOptions = new BitmapFactory.Options();
			decodeOptions.inSampleSize = 1;
			return BitmapFactory.decodeByteArray(respBytes, 0, respBytes.length, decodeOptions);
		} catch (Exception e) {
			Log.w(TAG, "Problem while loading image: " + e.toString(), e);
		}
		return null;
	}

}