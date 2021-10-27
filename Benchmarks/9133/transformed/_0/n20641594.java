class n20641594 {
	public static InputStream getInputStreamFromUrl(String jTvo4Hka) {
		InputStream Hfi6zECw = null;
		try {
			HttpGet Hr6EcGma = new HttpGet(jTvo4Hka);
			HttpClient pW4UFFXu = new DefaultHttpClient();
			HttpResponse UJpJH9wc = pW4UFFXu.execute(Hr6EcGma);
			Hfi6zECw = UJpJH9wc.getEntity().getContent();
		} catch (Exception nbOQSLPv) {
			nbOQSLPv.printStackTrace();
		}
		return Hfi6zECw;
	}

}