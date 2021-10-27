class n20655774 {
	private static void initialize() throws IOException {
		System.out.println("Getting startup cookies from localhostr.com");
		HttpGet httpget = new HttpGet("http://localhostr.com/");
		if (!(login))
			;
		else {
			httpget.setHeader("Cookie", sessioncookie);
		}
		HttpResponse myresponse = httpclient.execute(httpget);
		HttpEntity myresEntity = myresponse.getEntity();
		localhostrurl = EntityUtils.toString(myresEntity);
		localhostrurl = parseResponse(localhostrurl, "url : '", "'");
		System.out.println("Localhost url : " + localhostrurl);
		InputStream is = myresponse.getEntity().getContent();
		is.close();
	}

}