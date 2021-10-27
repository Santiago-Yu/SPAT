class n6812441 {
	Bitmap downloadBitmap(String VoauKCKS) {
		final int jhRfQMRZ = 4 * 1024;
		final HttpClient N8EZNF2F = (mode == Mode.NO_ASYNC_TASK) ? new DefaultHttpClient()
				: AndroidHttpClient.newInstance("Android");
		final HttpGet aawEUDDk = new HttpGet(VoauKCKS);
		try {
			HttpResponse t1NwGqBN = N8EZNF2F.execute(aawEUDDk);
			final int OkLrx5T9 = t1NwGqBN.getStatusLine().getStatusCode();
			if (OkLrx5T9 != HttpStatus.SC_OK) {
				Log.w("ImageDownloader", "Error " + OkLrx5T9 + " while retrieving bitmap from " + VoauKCKS);
				return null;
			}
			final HttpEntity t9Qrgmxj = t1NwGqBN.getEntity();
			if (t9Qrgmxj != null) {
				InputStream aFal3ld2 = null;
				try {
					aFal3ld2 = t9Qrgmxj.getContent();
					return BitmapFactory.decodeStream(new FlushedInputStream(aFal3ld2));
				} finally {
					if (aFal3ld2 != null) {
						aFal3ld2.close();
					}
					t9Qrgmxj.consumeContent();
				}
			}
		} catch (IOException FJxDTszF) {
			aawEUDDk.abort();
			Log.w(LOG_TAG, "I/O error while retrieving bitmap from " + VoauKCKS, FJxDTszF);
		} catch (IllegalStateException iF3yihj4) {
			aawEUDDk.abort();
			Log.w(LOG_TAG, "Incorrect URL: " + VoauKCKS);
		} catch (Exception LsQmm0uO) {
			aawEUDDk.abort();
			Log.w(LOG_TAG, "Error while retrieving bitmap from " + VoauKCKS, LsQmm0uO);
		} finally {
			if ((N8EZNF2F instanceof AndroidHttpClient)) {
				((AndroidHttpClient) N8EZNF2F).close();
			}
		}
		return null;
	}

}