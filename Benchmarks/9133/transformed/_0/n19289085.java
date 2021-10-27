class n19289085 {
	public void testSendMessage() throws ClientProtocolException, IOException {
		String HL620HOi = "La%20sua%20prenotazione%20e60%20andata%20a%20buon%20fine";
		String CNBQlDxm = "+393345730726";
		DefaultHttpClient wCB2H2Dt = new DefaultHttpClient();
		String j52zkVsJ = "http://smswizard.globalitalia.it/smsgateway/send.asp";
		String xXsXlhCe = j52zkVsJ + "?" + "Account=sardricerche" + "&Password=v8LomdZT" + "&PhoneNumbers=+393345730726"
				+ "&SMSData=" + HL620HOi + "&Recipients=1" + "&Sender=+393337589951" + "&ID=11762";
		HttpPost oTVzdaRq = new HttpPost(xXsXlhCe);
		HttpResponse A5HBI52m = wCB2H2Dt.execute(oTVzdaRq);
		HttpEntity XcgL0ywc = A5HBI52m.getEntity();
		String RD1mJkP0 = EntityUtils.toString(XcgL0ywc);
	}

}