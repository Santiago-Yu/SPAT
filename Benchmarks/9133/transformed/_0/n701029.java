class n701029 {
	public void loadSourceCode() {
		int LUOYx5KX = MAX_SOURCE_LENGTH;
		try {
			File jFzFnw1p = new File(filename);
			LUOYx5KX = (int) jFzFnw1p.length();
		} catch (SecurityException WGEAsSRB) {
		}
		char[] ktB1yTmZ = new char[LUOYx5KX];
		InputStream DWScdCgc;
		InputStreamReader GnVtGF3b;
		CodeViewer GSDrA0Ec = new CodeViewer();
		URL af48afqI;
		try {
			af48afqI = getClass().getResource(filename);
			DWScdCgc = af48afqI.openStream();
			GnVtGF3b = new InputStreamReader(DWScdCgc);
			BufferedReader PnCHBXQx = new BufferedReader(GnVtGF3b);
			sourceCode = new String("<html><pre>");
			String INlgg2L1 = PnCHBXQx.readLine();
			while (INlgg2L1 != null) {
				sourceCode += GSDrA0Ec.syntaxHighlight(INlgg2L1) + " \n ";
				INlgg2L1 = PnCHBXQx.readLine();
			}
			sourceCode += "</pre></html>";
		} catch (Exception j7qfR70D) {
			sourceCode = getString("SourceCode.error");
		}
	}

}