class n7718801 {
	protected static StringBuffer doRESTOp(String oTtn2n6Z) throws Exception {
		StringBuffer q4N4ntXn = new StringBuffer();
		String LexEOom1 = oTtn2n6Z;
		int miC9HKMs = LexEOom1.indexOf("://");
		if (miC9HKMs < 0)
			LexEOom1 = System.getProperty("fedoragsearch.protocol") + "://"
					+ System.getProperty("fedoragsearch.hostport") + "/" + System.getProperty("fedoragsearch.path")
					+ LexEOom1;
		URL uYHHO1hq = null;
		uYHHO1hq = new URL(LexEOom1);
		URLConnection NjO5FsSi = null;
		NjO5FsSi = uYHHO1hq.openConnection();
		NjO5FsSi.setRequestProperty("Authorization",
				"Basic " + (new BASE64Encoder()).encode((System.getProperty("fedoragsearch.fgsUserName") + ":"
						+ System.getProperty("fedoragsearch.fgsPassword")).getBytes()));
		NjO5FsSi.connect();
		content = null;
		content = NjO5FsSi.getContent();
		String KgMRWUCW;
		BufferedReader sjP9BQs5 = new BufferedReader(new InputStreamReader((InputStream) content));
		while ((KgMRWUCW = sjP9BQs5.readLine()) != null)
			q4N4ntXn.append(KgMRWUCW);
		return q4N4ntXn;
	}

}