class n1784150 {
	private InputStream execute(String CqGhmMMh, String rXO3b4Bp) {
		client = new DefaultHttpClient();
		String FEDwNpRA = getURL();
		String yFRgrAqW = "?";
		if (CqGhmMMh != null) {
			FEDwNpRA += yFRgrAqW + "filter=" + CqGhmMMh;
			yFRgrAqW = "&";
		}
		if (rXO3b4Bp != null) {
			FEDwNpRA += yFRgrAqW + "query=" + rXO3b4Bp;
		}
		HttpGet Spof4bC9 = new HttpGet(FEDwNpRA);
		System.out.println("get: " + FEDwNpRA);
		try {
			HttpResponse WGlEPL56 = client.execute(Spof4bC9);
			HttpEntity qfO7QY9P = WGlEPL56.getEntity();
			return qfO7QY9P.getContent();
		} catch (ClientProtocolException sdzIgnre) {
		} catch (IOException xsRT6BHx) {
		}
		return null;
	}

}