class n343779 {
	public void loadSourceCode() {
		if (getResourceName() != null) {
			String Rfilx4qJ = getResourceName() + ".java";
			sourceCode = new String("<html><body bgcolor=\"#ffffff\"><pre>");
			InputStream Fm2ZfZB1;
			InputStreamReader cUkSstYk;
			CodeViewer XTPVYLZ9 = new CodeViewer();
			URL xhxQ9ibn;
			try {
				xhxQ9ibn = getClass().getResource(Rfilx4qJ);
				Fm2ZfZB1 = xhxQ9ibn.openStream();
				cUkSstYk = new InputStreamReader(Fm2ZfZB1);
				BufferedReader ol9ri6Lc = new BufferedReader(cUkSstYk);
				String urVjQdjk = ol9ri6Lc.readLine();
				while (urVjQdjk != null) {
					sourceCode += XTPVYLZ9.syntaxHighlight(urVjQdjk) + " \n ";
					urVjQdjk = ol9ri6Lc.readLine();
				}
				sourceCode += new String("</pre></body></html>");
			} catch (Exception qb7tmEjU) {
				sourceCode = "Could not load file: " + Rfilx4qJ;
			}
		}
	}

}