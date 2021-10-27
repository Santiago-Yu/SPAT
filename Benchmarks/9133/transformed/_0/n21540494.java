class n21540494 {
	public int fileUpload(File vMo92ngN, String ljm6BHY3, Hashtable z8ldykPD) throws Exception {
		int PEAtsPh8 = 0;
		MultipartEntity Pymuoays = new MultipartEntity();
		if (ljm6BHY3 != null) {
			FileBody SH7aaolM = new FileBody(vMo92ngN);
			Pymuoays.addPart(ljm6BHY3, SH7aaolM);
		}
		Enumeration<String> hqT34ux8 = z8ldykPD.keys();
		String m7hRMACM;
		while (hqT34ux8.hasMoreElements()) {
			m7hRMACM = hqT34ux8.nextElement();
			Pymuoays.addPart(m7hRMACM, new StringBody("" + z8ldykPD.get(m7hRMACM)));
		}
		httpPost.setEntity(Pymuoays);
		HttpResponse hewcqVYg = httpclient.execute(httpPost);
		HttpEntity sQIQYVDb = hewcqVYg.getEntity();
		PEAtsPh8 = hewcqVYg.getStatusLine().getStatusCode();
		close();
		return PEAtsPh8;
	}

}