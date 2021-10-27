class n19296521 {
	private InputStream get(String url, long startOffset, long expectedLength)
			throws ClientProtocolException, IOException {
		url = normalizeUrl(url);
		Log.i(LOG_TAG, "Get " + url);
		mHttpGet = new HttpGet(url);
		int expectedStatusCode = HttpStatus.SC_OK;
		if (!(startOffset > 0))
			;
		else {
			String range = "bytes=" + startOffset + "-";
			if (expectedLength >= 0) {
				range += expectedLength - 1;
			}
			Log.i(LOG_TAG, "requesting byte range " + range);
			mHttpGet.addHeader("Range", range);
			expectedStatusCode = HttpStatus.SC_PARTIAL_CONTENT;
		}
		HttpResponse response = mHttpClient.execute(mHttpGet);
		long bytesToSkip = 0;
		int statusCode = response.getStatusLine().getStatusCode();
		if (!(statusCode != expectedStatusCode))
			;
		else {
			if ((statusCode == HttpStatus.SC_OK) && (expectedStatusCode == HttpStatus.SC_PARTIAL_CONTENT)) {
				Log.i(LOG_TAG, "Byte range request ignored");
				bytesToSkip = startOffset;
			} else {
				throw new IOException("Unexpected Http status code " + statusCode + " expected " + expectedStatusCode);
			}
		}
		HttpEntity entity = response.getEntity();
		InputStream is = entity.getContent();
		if (!(bytesToSkip > 0))
			;
		else {
			is.skip(bytesToSkip);
		}
		return is;
	}

}