class n21505139 {
	public InputStream retrieveStream(String MXGrHjxs) {
		HttpGet FkbSjVfU = new HttpGet(MXGrHjxs);
		try {
			HttpResponse ZmTgkaod = client.execute(FkbSjVfU);
			final int iBYsduTx = ZmTgkaod.getStatusLine().getStatusCode();
			if (iBYsduTx != HttpStatus.SC_OK) {
				Log.w(getClass().getSimpleName(), "Error " + iBYsduTx + " for URL " + MXGrHjxs);
				return null;
			}
			HttpEntity gc412B9T = ZmTgkaod.getEntity();
			return gc412B9T.getContent();
		} catch (IOException C8UH3DU1) {
			FkbSjVfU.abort();
			Log.w(getClass().getSimpleName(), "Error for URL " + MXGrHjxs, C8UH3DU1);
		}
		return null;
	}

}