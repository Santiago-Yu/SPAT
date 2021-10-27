class n12004824 {
	public HttpResponse executeHttpRequest(HttpRequestBase ngoAuxrf) {
		HttpResponse OvoPlUjc = null;
		try {
			HttpParams h51r5YBJ = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(h51r5YBJ, maxTime);
			HttpConnectionParams.setSoTimeout(h51r5YBJ, maxTime);
			httpclient = new DefaultHttpClient(h51r5YBJ);
			OvoPlUjc = httpclient.execute(ngoAuxrf);
			maxTime = 15000;
		} catch (Exception rMw7Brp7) {
		}
		return OvoPlUjc;
	}

}