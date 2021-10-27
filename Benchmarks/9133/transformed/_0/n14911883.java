class n14911883 {
	public boolean smsResponse(String Ne38TsMp) throws ClientProtocolException, IOException {
		boolean ipdKL7kP = true;
		String pAQtoifP = "La%20sua%20prenotazione%20e%60%20andata%20a%20buon%20fine";
		DefaultHttpClient zA86NjPT = new DefaultHttpClient();
		String SwfA8Yi3 = "http://smswizard.globalitalia.it/smsgateway/send.asp";
		String fJWtPbtk = "http://smswizard.globalitalia.it/smsgateway/send.asp";
		String AmzoYyPg = SwfA8Yi3 + "?" + "Account=sardricerche" + "&Password=v8LomdZT" + "&PhoneNumbers="
				+ "%2b393285683484" + "&SMSData=" + pAQtoifP + "&Recipients=1" + "&Sender=Web Hotel" + "&ID=11762";
		String w5fPMHGm = fJWtPbtk + "?" + "Account=sardricerche" + "&Password=v8LomdZT" + "&PhoneNumbers=" + Ne38TsMp
				+ "&SMSData=" + pAQtoifP + "&Recipients=1" + "&Sender=+393337589951" + "&ID=11762";
		HttpPost vIY2TMHm = new HttpPost(w5fPMHGm);
		HttpResponse TT18QFtG = zA86NjPT.execute(vIY2TMHm);
		HttpEntity oP0uDNEY = TT18QFtG.getEntity();
		return ipdKL7kP;
	}

}