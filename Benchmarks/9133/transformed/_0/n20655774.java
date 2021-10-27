class n20655774 {
	private static void initialize() throws IOException {
		System.out.println("Getting startup cookies from localhostr.com");
		HttpGet mWuLSS89 = new HttpGet("http://localhostr.com/");
		if (login) {
			mWuLSS89.setHeader("Cookie", sessioncookie);
		}
		HttpResponse mFhE45eh = httpclient.execute(mWuLSS89);
		HttpEntity FTfUhO2B = mFhE45eh.getEntity();
		localhostrurl = EntityUtils.toString(FTfUhO2B);
		localhostrurl = parseResponse(localhostrurl, "url : '", "'");
		System.out.println("Localhost url : " + localhostrurl);
		InputStream pcfnztSI = mFhE45eh.getEntity().getContent();
		pcfnztSI.close();
	}

}