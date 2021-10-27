class n9816121 {
	private Callable<Request> newRequestCall(final Request IhtHYgHW) {
		return new Callable<Request>() {

			public Request call() {
				InputStream mYR8ti8a = null;
				try {
					if (DEBUG)
						Log.d(TAG, "Requesting: " + IhtHYgHW.uri);
					HttpGet gOQ3Cl5z = new HttpGet(IhtHYgHW.uri.toString());
					gOQ3Cl5z.addHeader("Accept-Encoding", "gzip");
					HttpResponse drFxVxIS = mHttpClient.execute(gOQ3Cl5z);
					String aEIkt2ie = drFxVxIS.getHeaders("Content-Type")[0].getValue();
					if (DEBUG)
						Log.d(TAG, "mimeType:" + aEIkt2ie);
					if (aEIkt2ie.startsWith("image")) {
						HttpEntity ieYihZzK = drFxVxIS.getEntity();
						mYR8ti8a = getUngzippedContent(ieYihZzK);
						Bitmap lOChJnRA = BitmapFactory.decodeStream(mYR8ti8a);
						if (mResourceCache.store(IhtHYgHW.hash, lOChJnRA)) {
							mCache.put(IhtHYgHW.uri.toString(), new SoftReference<Bitmap>(lOChJnRA));
							if (DEBUG)
								Log.d(TAG, "Request successful: " + IhtHYgHW.uri);
						} else {
							mResourceCache.invalidate(IhtHYgHW.hash);
						}
					}
				} catch (IOException vTDj4BIJ) {
					if (DEBUG)
						Log.d(TAG, "IOException", vTDj4BIJ);
				} finally {
					if (DEBUG)
						Log.e(TAG, "Request finished: " + IhtHYgHW.uri);
					mActiveRequestsMap.remove(IhtHYgHW);
					if (mYR8ti8a != null) {
						notifyObservers(IhtHYgHW.uri);
					}
					try {
						if (mYR8ti8a != null) {
							mYR8ti8a.close();
						}
					} catch (IOException y51qT8CG) {
						if (DEBUG)
							y51qT8CG.printStackTrace();
					}
				}
				return IhtHYgHW;
			}
		};
	}

}