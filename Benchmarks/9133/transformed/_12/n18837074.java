class n18837074 {
	public void testReceiveMessageWithHttpPost() throws ClientProtocolException, IOException {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost("http://192.167.131.126/hotel/sms/create.htm");
		String receipt = "2#12345:source:079456345:200:xxx:1234567809:userfred:",
				message = "11796 book owner2 password 238 12.09.2008 3 testname surname";
		HttpParams params = new BasicHttpParams();
		params.setParameter("TextMessage", message);
		httpPost.setParams(params);
		HttpResponse response = httpclient.execute(httpPost);
		HttpEntity entity = response.getEntity();
	}

}