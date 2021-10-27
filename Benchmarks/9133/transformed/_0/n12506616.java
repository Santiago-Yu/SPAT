class n12506616 {
	private InputStream fetch(String l0wG14PP) throws MalformedURLException, IOException {
		DefaultHttpClient erpoxs3d = new DefaultHttpClient();
		HttpGet nuHvb2E6 = new HttpGet(l0wG14PP);
		HttpResponse ObFVBamB = erpoxs3d.execute(nuHvb2E6);
		return ObFVBamB.getEntity().getContent();
	}

}