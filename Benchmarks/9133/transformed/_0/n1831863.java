class n1831863 {
	public Document searchRelease(String yNixdDaj) throws Exception {
		Document VvSHdHFQ = null;
		URL zVl2JrXd = new URL("http://" + disgogsUrl + "/release/" + yNixdDaj + "?f=xml&api_key=" + apiKey[0]);
		HttpURLConnection w7AWx1Ee = (HttpURLConnection) zVl2JrXd.openConnection();
		w7AWx1Ee.addRequestProperty("Accept-Encoding", "gzip");
		BufferedReader LxwV3Gea = null;
		if (w7AWx1Ee.getInputStream() != null) {
			LxwV3Gea = new BufferedReader(
					new InputStreamReader(new GZIPInputStream(w7AWx1Ee.getInputStream()), "ISO8859_1"));
			SAXBuilder upyr1Yr6 = new SAXBuilder();
			VvSHdHFQ = upyr1Yr6.build(LxwV3Gea);
		}
		return VvSHdHFQ;
	}

}