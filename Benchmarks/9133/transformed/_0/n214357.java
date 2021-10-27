class n214357 {
	public void loadSourceCode() {
		int HqDnPdcw = MAX_SOURCE_LENGTH;
		try {
			File kBkS7kum = new File(filename);
			HqDnPdcw = (int) kBkS7kum.length();
		} catch (SecurityException KGBBxyIW) {
		}
		char[] rO2qCcpA = new char[HqDnPdcw];
		InputStream dMIbW6LD;
		InputStreamReader lV80NbaY;
		CodeViewer gyvOMrIP = new CodeViewer();
		URL xvrwCAgc;
		try {
			xvrwCAgc = getClass().getResource(filename);
			dMIbW6LD = xvrwCAgc.openStream();
			lV80NbaY = new InputStreamReader(dMIbW6LD);
			BufferedReader fEFJrZ6N = new BufferedReader(lV80NbaY);
			sourceCode = new String("<html><pre>");
			String MP9CrhDv = fEFJrZ6N.readLine();
			while (MP9CrhDv != null) {
				sourceCode += gyvOMrIP.syntaxHighlight(MP9CrhDv) + " \n ";
				MP9CrhDv = fEFJrZ6N.readLine();
			}
			sourceCode += "</pre></html>";
		} catch (Exception JcfQts7b) {
			sourceCode = getString("SourceCode.error");
		}
	}

}