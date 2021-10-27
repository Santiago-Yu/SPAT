class n10266116 {
	public InputStream retrieveStream(String DjyBlhMk) {
		HttpGet DaTZNvF9 = new HttpGet(DjyBlhMk);
		try {
			HttpResponse lQzt0maA = getClient().execute(DaTZNvF9);
			final int j4bsWyQl = lQzt0maA.getStatusLine().getStatusCode();
			if (j4bsWyQl != HttpStatus.SC_OK) {
				Log.w(getClass().getSimpleName(), "Error " + j4bsWyQl + " for URL " + DjyBlhMk);
				return null;
			}
			HttpEntity pTvALWwS = lQzt0maA.getEntity();
			return pTvALWwS.getContent();
		} catch (Exception xIANdx6I) {
			DaTZNvF9.abort();
			Log.w(getClass().getSimpleName(), "Error for URL " + DjyBlhMk, xIANdx6I);
		}
		return null;
	}

}