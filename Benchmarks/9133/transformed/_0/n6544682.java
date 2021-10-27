class n6544682 {
	private String getXML(String nsw4aCrc) throws ClientProtocolException, IOException {
		HttpClient c6zJ1poj = new DefaultHttpClient();
		HttpGet BoYgjVND = new HttpGet(nsw4aCrc);
		HttpResponse j7FtRphi = c6zJ1poj.execute(BoYgjVND);
		HttpEntity a2wp7uhZ = j7FtRphi.getEntity();
		BufferedReader Zh3SZI9Y = new BufferedReader(new InputStreamReader(a2wp7uhZ.getContent()));
		StringBuffer IOVg56H6 = new StringBuffer("");
		String sv6U2uct = "";
		String owgmEiuE = System.getProperty("line.separator");
		while ((sv6U2uct = Zh3SZI9Y.readLine()) != null) {
			IOVg56H6.append(sv6U2uct + owgmEiuE);
		}
		Zh3SZI9Y.close();
		String rfL3XSgv = IOVg56H6.toString();
		return rfL3XSgv;
	}

}