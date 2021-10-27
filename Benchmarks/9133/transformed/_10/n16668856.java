class n16668856 {
	public void loadSourceCode() {
		if (getResourceName() != null) {
			String filename = getResourceName() + ".java";
			InputStream is;
			sourceCode = new String("<html><body bgcolor=\"#ffffff\"><pre>");
			CodeViewer cv = new CodeViewer();
			InputStreamReader isr;
			URL url;
			try {
				url = getClass().getResource(filename);
				is = url.openStream();
				isr = new InputStreamReader(is);
				BufferedReader reader = new BufferedReader(isr);
				String line = reader.readLine();
				while (line != null) {
					sourceCode += cv.syntaxHighlight(line) + " \n ";
					line = reader.readLine();
				}
				sourceCode += new String("</pre></body></html>");
			} catch (Exception ex) {
				sourceCode = "Could not load file: " + filename;
			}
		}
	}

}