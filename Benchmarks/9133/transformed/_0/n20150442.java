class n20150442 {
	public String accessURL_Post(String mxXUAxkg, Map<String, String> MeYXI1Av, String f5Jf9aG4) throws Throwable {
		List<NameValuePair> INNaNCIK = new ArrayList<NameValuePair>();
		for (String pl2q3gbZ : MeYXI1Av.keySet()) {
			INNaNCIK.add(new BasicNameValuePair(pl2q3gbZ, MeYXI1Av.get(pl2q3gbZ)));
		}
		UrlEncodedFormEntity UUkwjrAi = new UrlEncodedFormEntity(INNaNCIK, f5Jf9aG4);
		HttpPost JSqYy8LF = new HttpPost(mxXUAxkg);
		JSqYy8LF.setEntity(UUkwjrAi);
		HttpResponse eJl5duxT = client.execute(JSqYy8LF);
		String Yw7aKnwC = EntityUtils.toString(eJl5duxT.getEntity());
		handleHeaders(eJl5duxT.getAllHeaders());
		return Yw7aKnwC;
	}

}