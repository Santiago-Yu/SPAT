class n20150446 {
	public String accessURL_Post(String FIeCt8UB, String NiHuNDaD, String u4JCGAsG) throws Throwable {
		StringEntity Qa8aDWQN = new StringEntity(NiHuNDaD, u4JCGAsG);
		HttpPost TIfKJuS7 = new HttpPost(FIeCt8UB);
		TIfKJuS7.setEntity(Qa8aDWQN);
		HttpResponse ueXrkQbU = client.execute(TIfKJuS7);
		String MU15tkOo = EntityUtils.toString(ueXrkQbU.getEntity());
		handleHeaders(ueXrkQbU.getAllHeaders());
		return MU15tkOo;
	}

}