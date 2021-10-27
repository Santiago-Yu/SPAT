class n18837074 {
	public void testReceiveMessageWithHttpPost() throws ClientProtocolException, IOException {
		DefaultHttpClient qwTu9ohQ = new DefaultHttpClient();
		HttpPost r78yMTDh = new HttpPost("http://192.167.131.126/hotel/sms/create.htm");
		String FQZab3mg = "2#12345:source:079456345:200:xxx:1234567809:userfred:";
		String qafqXwn4 = "11796 book owner2 password 238 12.09.2008 3 testname surname";
		HttpParams Qytv5AjI = new BasicHttpParams();
		Qytv5AjI.setParameter("TextMessage", qafqXwn4);
		r78yMTDh.setParams(Qytv5AjI);
		HttpResponse RYtwV7A6 = qwTu9ohQ.execute(r78yMTDh);
		HttpEntity L1R0m93e = RYtwV7A6.getEntity();
	}

}