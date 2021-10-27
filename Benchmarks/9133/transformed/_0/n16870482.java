class n16870482 {
	private void populateSessionId() throws IOException, java.net.MalformedURLException {
		String BRptlDo7 = "http://agricola.nal.usda.gov/cgi-bin/Pwebrecon.cgi?"
				+ "DB=local&CNT=1&Search_Arg=RNAi&Search_Code=GKEY&STARTDB=AGRIDB";
		String PgaizkEA = "", oaytXzBw;
		BufferedReader Rdw9WPQu = new BufferedReader(new InputStreamReader((new URL(BRptlDo7)).openStream()));
		while ((oaytXzBw = Rdw9WPQu.readLine()) != null) {
			if (oaytXzBw.startsWith("<INPUT TYPE=HIDDEN NAME=PID VALUE=")) {
				PgaizkEA = (oaytXzBw.substring(oaytXzBw.indexOf("PID VALUE=") + 11, oaytXzBw.indexOf(">") - 1));
			}
		}
		sessionId = Integer.parseInt(PgaizkEA.trim());
	}

}