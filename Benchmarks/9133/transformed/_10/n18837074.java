class n18837074 {
	public void testReceiveMessageWithHttpPost() throws ClientProtocolException, IOException {
		HttpPost httpPost = new HttpPost("http://192.167.131.126/hotel/sms/create.htm");
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String receipt = "2#12345:source:079456345:200:xxx:1234567809:userfred:";
		HttpParams params = new BasicHttpParams();
		String message = "11796 book owner2 password 238 12.09.2008 3 testname surname";
		params.setParameter("TextMessage", message);
		httpPost.setParams(params);
		HttpResponse response = httpclient.execute(httpPost);
		HttpEntity entity = response.getEntity();
	}

}