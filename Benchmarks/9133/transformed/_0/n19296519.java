class n19296519 {
	private long getSize(String IpWOsNBV) throws ClientProtocolException, IOException {
		IpWOsNBV = normalizeUrl(IpWOsNBV);
		Log.i(LOG_TAG, "Head " + IpWOsNBV);
		HttpHead HrqZSDPE = new HttpHead(IpWOsNBV);
		HttpResponse f0xPRjwy = mHttpClient.execute(HrqZSDPE);
		if (f0xPRjwy.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			throw new IOException("Unexpected Http status code " + f0xPRjwy.getStatusLine().getStatusCode());
		}
		Header[] fm498iLq = f0xPRjwy.getHeaders("Content-Length");
		if (fm498iLq.length > 0) {
			Header Sojxub3q = fm498iLq[0];
			return Long.parseLong(Sojxub3q.getValue());
		}
		return -1;
	}

}