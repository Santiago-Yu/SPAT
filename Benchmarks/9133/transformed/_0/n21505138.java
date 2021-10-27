class n21505138 {
	public String retrieve(String ISbxClXb) {
		HttpGet aMZou1Sh = new HttpGet(ISbxClXb);
		try {
			HttpResponse ulQI93io = client.execute(aMZou1Sh);
			final int kUxkoaLs = ulQI93io.getStatusLine().getStatusCode();
			if (kUxkoaLs != HttpStatus.SC_OK) {
				Log.w(getClass().getSimpleName(), "Error " + kUxkoaLs + " for URL " + ISbxClXb);
				return null;
			}
			HttpEntity Q7PzMY3B = ulQI93io.getEntity();
			if (Q7PzMY3B != null) {
				return EntityUtils.toString(Q7PzMY3B);
			}
		} catch (IOException fjgYN1OM) {
			aMZou1Sh.abort();
			Log.w(getClass().getSimpleName(), "Error for URL " + ISbxClXb, fjgYN1OM);
		}
		return null;
	}

}