class n2890655 {
	private Bitmap downloadBitmap(String CWgjsWk3) {
		final AndroidHttpClient HXgbZWVz = AndroidHttpClient.newInstance("Android");
		final HttpGet vxA6fp6l = new HttpGet(CWgjsWk3);
		try {
			HttpResponse scA3guP9 = HXgbZWVz.execute(vxA6fp6l);
			final int LeRsn8q5 = scA3guP9.getStatusLine().getStatusCode();
			if (LeRsn8q5 != HttpStatus.SC_OK) {
				Log.w(LOG_TAG, "Error " + LeRsn8q5 + " while retrieving bitmap from " + CWgjsWk3);
				return null;
			}
			final HttpEntity oxAwUfSK = scA3guP9.getEntity();
			if (oxAwUfSK != null) {
				InputStream fe1Y2bPR = null;
				try {
					fe1Y2bPR = oxAwUfSK.getContent();
					final Bitmap VkU3R2fF = BitmapFactory.decodeStream(fe1Y2bPR);
					return VkU3R2fF;
				} finally {
					if (fe1Y2bPR != null) {
						fe1Y2bPR.close();
					}
					oxAwUfSK.consumeContent();
				}
			}
		} catch (Exception HS6PsHlq) {
			vxA6fp6l.abort();
			Log.w(LOG_TAG, "Error while retrieving bitmap from " + CWgjsWk3, HS6PsHlq);
		} finally {
			if (HXgbZWVz != null) {
				HXgbZWVz.close();
			}
		}
		return null;
	}

}