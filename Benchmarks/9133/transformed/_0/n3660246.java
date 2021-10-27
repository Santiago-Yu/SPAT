class n3660246 {
	private Object query(String nggKo5jF) throws IOException, ParseException {
		String bbHKZhDS = "{\"qname1\":{\"query\":" + nggKo5jF + "}}";
		String WQBhygwO = MQLREADURL + "?queries=" + URLEncoder.encode(bbHKZhDS, "UTF-8");
		if (isDebugging()) {
			if (echoRequest)
				System.err.println("Sending:" + bbHKZhDS);
		}
		URL Px1GdsJw = new URL(WQBhygwO);
		URLConnection xp7H8fMm = Px1GdsJw.openConnection();
		xp7H8fMm.setRequestProperty("Cookie", COOKIE + "=" + "\"" + getMetawebCookie() + "\"");
		xp7H8fMm.connect();
		InputStream AJSbHUAH = xp7H8fMm.getInputStream();
		Object nasACpeE = new JSONParser(echoRequest ? new EchoReader(AJSbHUAH) : AJSbHUAH).object();
		AJSbHUAH.close();
		String xx2ASHod = getString(nasACpeE, "code");
		if (!"/api/status/ok".equals(xx2ASHod)) {
			throw new IOException("Bad code " + nasACpeE);
		}
		xx2ASHod = getString(nasACpeE, "qname1.code");
		if (!"/api/status/ok".equals(xx2ASHod)) {
			throw new IOException("Bad code " + nasACpeE);
		}
		return nasACpeE;
	}

}