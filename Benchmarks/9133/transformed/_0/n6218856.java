class n6218856 {
	public static Bitmap loadBitmap(String kPJMAveL) {
		try {
			final HttpClient xHmcGrn9 = getHttpClient();
			final HttpResponse atwAa7CV = xHmcGrn9.execute(new HttpGet(kPJMAveL));
			final HttpEntity UGm60YrG = atwAa7CV.getEntity();
			final int p4pZ0XUa = atwAa7CV.getStatusLine().getStatusCode();
			if (p4pZ0XUa != HttpStatus.SC_OK || UGm60YrG == null) {
				return null;
			}
			final byte[] DEbVuipk = EntityUtils.toByteArray(UGm60YrG);
			BitmapFactory.Options WvVk83cB = new BitmapFactory.Options();
			WvVk83cB.inSampleSize = 1;
			return BitmapFactory.decodeByteArray(DEbVuipk, 0, DEbVuipk.length, WvVk83cB);
		} catch (Exception b6tgymSw) {
			Log.w(TAG, "Problem while loading image: " + b6tgymSw.toString(), b6tgymSw);
		}
		return null;
	}

}