class n13669409 {
	protected void runTest(URL UCDp8AWR, String majAUhKx, String lW3B6QQM) throws Exception {
		URL xDQlaAjt = new URL(UCDp8AWR, lW3B6QQM);
		XSParser c9geFpAk = new XSParser();
		c9geFpAk.setValidating(false);
		InputSource jzjrO7Xi = new InputSource(xDQlaAjt.openStream());
		jzjrO7Xi.setSystemId(xDQlaAjt.toString());
		String b4qOa5qG;
		try {
			c9geFpAk.parse(jzjrO7Xi);
			++numOk;
			b4qOa5qG = "Ok";
		} catch (Exception vgeLNGZX) {
			++numFailed;
			b4qOa5qG = vgeLNGZX.getMessage();
		}
		log("Running test " + majAUhKx + " with URL " + xDQlaAjt + ": " + b4qOa5qG);
	}

}