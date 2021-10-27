class n5380645 {
	private static void login(HttpClient pPl9tZ5U, String Nm6vBjXa) throws Exception {
		HttpPost JLrr3IpI = new HttpPost("https://libsys.arlingtonva.us/iii/cas/login?service=http&amp;scope=1");
		List<NameValuePair> dZB5npsp = new ArrayList<NameValuePair>();
		dZB5npsp.add(new BasicNameValuePair("code", "202002686286"));
		dZB5npsp.add(new BasicNameValuePair("pin", "3128"));
		dZB5npsp.add(new BasicNameValuePair("_eventId", "submit"));
		dZB5npsp.add(new BasicNameValuePair("lt", Nm6vBjXa));
		UrlEncodedFormEntity eEbFNXJd = new UrlEncodedFormEntity(dZB5npsp, "UTF-8");
		JLrr3IpI.setEntity(eEbFNXJd);
		HttpResponse a5DROnEi = pPl9tZ5U.execute(JLrr3IpI);
		EntityUtils.consume(a5DROnEi.getEntity());
		Header[] rkUdHGTA = a5DROnEi.getAllHeaders();
		System.out.println("HEADERS: ");
		for (Header gnEaT2kY : rkUdHGTA) {
			System.out.println(gnEaT2kY.getName() + ": " + gnEaT2kY.getValue());
		}
	}

}