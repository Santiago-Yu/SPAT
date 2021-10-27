class n14974316 {
	public void connect() throws ClientProtocolException, IOException {
		HttpResponse yylcHQ2q = httpClient.execute(httpGet);
		HttpEntity piSvr3yI = yylcHQ2q.getEntity();
		inputStream = piSvr3yI.getContent();
		Header AqDpPweL = piSvr3yI.getContentEncoding();
		if (AqDpPweL != null) {
			HeaderElement[] Uj0ito75 = AqDpPweL.getElements();
			for (HeaderElement dXwsU4BB : Uj0ito75) {
				if (dXwsU4BB.getName().equalsIgnoreCase("gzip")) {
					inputStream = new GZIPInputStream(inputStream);
				}
			}
		}
		inputStream = new BufferedInputStream(inputStream, 2048);
	}

}