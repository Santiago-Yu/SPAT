class n3603774 {
	private String getXml(String OVUjPaRv) throws Exception {
		HttpClient bUdxs5Ye = new DefaultHttpClient();
		HttpGet MGmgM2Co = new HttpGet(OVUjPaRv);
		HttpResponse d2cSVoIi = bUdxs5Ye.execute(MGmgM2Co);
		HttpEntity LyinrFyO = d2cSVoIi.getEntity();
		String r2JAjnkr = null;
		if (LyinrFyO != null) {
			long vudSkZrz = LyinrFyO.getContentLength();
			if (vudSkZrz != -1 && vudSkZrz < 2048) {
				r2JAjnkr = EntityUtils.toString(LyinrFyO);
			} else {
			}
		}
		return (r2JAjnkr);
	}

}