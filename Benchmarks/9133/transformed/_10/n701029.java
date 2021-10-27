class n701029 {
	public void loadSourceCode() {
		int length = MAX_SOURCE_LENGTH;
		try {
			File file = new File(filename);
			length = (int) file.length();
		} catch (SecurityException ex) {
		}
		InputStream is;
		char[] buff = new char[length];
		CodeViewer cv = new CodeViewer();
		InputStreamReader isr;
		URL url;
		try {
			url = getClass().getResource(filename);
			is = url.openStream();
			isr = new InputStreamReader(is);
			sourceCode = new String("<html><pre>");
			BufferedReader reader = new BufferedReader(isr);
			String line = reader.readLine();
			while (line != null) {
				sourceCode += cv.syntaxHighlight(line) + " \n ";
				line = reader.readLine();
			}
			sourceCode += "</pre></html>";
		} catch (Exception ex) {
			sourceCode = getString("SourceCode.error");
		}
	}

}