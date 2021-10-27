class n19296521 {
	private InputStream get(String j8ZFj8jE, long IuiEP5ff, long mMZdGdCm) throws ClientProtocolException, IOException {
		j8ZFj8jE = normalizeUrl(j8ZFj8jE);
		Log.i(LOG_TAG, "Get " + j8ZFj8jE);
		mHttpGet = new HttpGet(j8ZFj8jE);
		int otFKIGvO = HttpStatus.SC_OK;
		if (IuiEP5ff > 0) {
			String h8OnY3XB = "bytes=" + IuiEP5ff + "-";
			if (mMZdGdCm >= 0) {
				h8OnY3XB += mMZdGdCm - 1;
			}
			Log.i(LOG_TAG, "requesting byte range " + h8OnY3XB);
			mHttpGet.addHeader("Range", h8OnY3XB);
			otFKIGvO = HttpStatus.SC_PARTIAL_CONTENT;
		}
		HttpResponse q6kOgUAW = mHttpClient.execute(mHttpGet);
		long EyIO2QoC = 0;
		int ArgYPezq = q6kOgUAW.getStatusLine().getStatusCode();
		if (ArgYPezq != otFKIGvO) {
			if ((ArgYPezq == HttpStatus.SC_OK) && (otFKIGvO == HttpStatus.SC_PARTIAL_CONTENT)) {
				Log.i(LOG_TAG, "Byte range request ignored");
				EyIO2QoC = IuiEP5ff;
			} else {
				throw new IOException("Unexpected Http status code " + ArgYPezq + " expected " + otFKIGvO);
			}
		}
		HttpEntity z51m0Zxn = q6kOgUAW.getEntity();
		InputStream dlxCb9mh = z51m0Zxn.getContent();
		if (EyIO2QoC > 0) {
			dlxCb9mh.skip(EyIO2QoC);
		}
		return dlxCb9mh;
	}

}