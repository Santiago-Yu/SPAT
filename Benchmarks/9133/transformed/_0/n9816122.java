class n9816122 {
	public Request call() {
		InputStream z6T1bYeb = null;
		try {
			if (DEBUG)
				Log.d(TAG, "Requesting: " + request.uri);
			HttpGet CNgWvIO9 = new HttpGet(request.uri.toString());
			CNgWvIO9.addHeader("Accept-Encoding", "gzip");
			HttpResponse P8JJLeII = mHttpClient.execute(CNgWvIO9);
			String TmlQPBei = P8JJLeII.getHeaders("Content-Type")[0].getValue();
			if (DEBUG)
				Log.d(TAG, "mimeType:" + TmlQPBei);
			if (TmlQPBei.startsWith("image")) {
				HttpEntity NiB3yzaT = P8JJLeII.getEntity();
				z6T1bYeb = getUngzippedContent(NiB3yzaT);
				Bitmap NE1tKT1Q = BitmapFactory.decodeStream(z6T1bYeb);
				if (mResourceCache.store(request.hash, NE1tKT1Q)) {
					mCache.put(request.uri.toString(), new SoftReference<Bitmap>(NE1tKT1Q));
					if (DEBUG)
						Log.d(TAG, "Request successful: " + request.uri);
				} else {
					mResourceCache.invalidate(request.hash);
				}
			}
		} catch (IOException KxV1kL5C) {
			if (DEBUG)
				Log.d(TAG, "IOException", KxV1kL5C);
		} finally {
			if (DEBUG)
				Log.e(TAG, "Request finished: " + request.uri);
			mActiveRequestsMap.remove(request);
			if (z6T1bYeb != null) {
				notifyObservers(request.uri);
			}
			try {
				if (z6T1bYeb != null) {
					z6T1bYeb.close();
				}
			} catch (IOException mo5OITdV) {
				if (DEBUG)
					mo5OITdV.printStackTrace();
			}
		}
		return request;
	}

}