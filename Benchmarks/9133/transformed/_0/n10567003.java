class n10567003 {
	private InputStream loadSource(String KyesBcSE) throws ClientProtocolException, IOException {
		HttpClient EmGzrKur = new DefaultHttpClient();
		EmGzrKur.getParams().setParameter(HTTP.USER_AGENT, "Mozilla/4.0 (compatible; MSIE 7.0b; Windows NT 6.0)");
		HttpGet FdVQbFDw = new HttpGet(KyesBcSE);
		HttpResponse w3nmpThf = EmGzrKur.execute(FdVQbFDw);
		HttpEntity WbeI5JFT = w3nmpThf.getEntity();
		return WbeI5JFT.getContent();
	}

}