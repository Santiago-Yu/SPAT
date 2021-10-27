class n14911883 {
	public boolean smsResponse(String customerPhoneNumber) throws ClientProtocolException, IOException {
		String textMessage = "La%20sua%20prenotazione%20e%60%20andata%20a%20buon%20fine";
		boolean message = true;
		String uri = "http://smswizard.globalitalia.it/smsgateway/send.asp";
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String other = "http://smswizard.globalitalia.it/smsgateway/send.asp";
		String url = uri + "?" + "Account=sardricerche" + "&Password=v8LomdZT" + "&PhoneNumbers=" + "%2b393285683484"
				+ "&SMSData=" + textMessage + "&Recipients=1" + "&Sender=Web Hotel" + "&ID=11762";
		String urlProva = other + "?" + "Account=sardricerche" + "&Password=v8LomdZT" + "&PhoneNumbers="
				+ customerPhoneNumber + "&SMSData=" + textMessage + "&Recipients=1" + "&Sender=+393337589951"
				+ "&ID=11762";
		HttpPost httpPost = new HttpPost(urlProva);
		HttpResponse response = httpclient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		return message;
	}

}