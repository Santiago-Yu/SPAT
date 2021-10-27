class n19983153 {
	public static Bitmap loadBitmap(String m8Wp7h5W) {
		try {
			final HttpClient ntU2s9bC = getHttpClient();
			final HttpResponse WAiyZ3Mq = ntU2s9bC.execute(new HttpGet(m8Wp7h5W));
			final HttpEntity uYewt7za = WAiyZ3Mq.getEntity();
			final int G4l4V4PU = WAiyZ3Mq.getStatusLine().getStatusCode();
			if (G4l4V4PU != HttpStatus.SC_OK || uYewt7za == null) {
				return null;
			}
			final byte[] k7FDZnRk = EntityUtils.toByteArray(uYewt7za);
			BitmapFactory.Options yfY48tRq = new BitmapFactory.Options();
			yfY48tRq.inSampleSize = 1;
			return BitmapFactory.decodeByteArray(k7FDZnRk, 0, k7FDZnRk.length, yfY48tRq);
		} catch (Exception WPelnK1Q) {
			Log.w(TAG, "Problem while loading image: " + WPelnK1Q.toString(), WPelnK1Q);
		}
		return null;
	}

}