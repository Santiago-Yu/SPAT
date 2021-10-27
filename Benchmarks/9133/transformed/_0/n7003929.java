class n7003929 {
	public URLConnection openConnection(String Pj58DOW0) throws ParserException {
		final String zPmk1Ocu = "file://localhost";
		String qEnVSvdB;
		URL ca4ozqGY;
		StringBuffer OeKrWOY6;
		URLConnection htjckyL6;
		try {
			ca4ozqGY = new URL(fixSpaces(Pj58DOW0));
			htjckyL6 = openConnection(ca4ozqGY);
		} catch (MalformedURLException oWIghoTI) {
			try {
				File QIY2lEYr = new File(Pj58DOW0);
				qEnVSvdB = QIY2lEYr.getCanonicalPath();
				OeKrWOY6 = new StringBuffer(zPmk1Ocu.length() + qEnVSvdB.length());
				OeKrWOY6.append(zPmk1Ocu);
				if (!qEnVSvdB.startsWith("/"))
					OeKrWOY6.append("/");
				OeKrWOY6.append(qEnVSvdB);
				ca4ozqGY = new URL(fixSpaces(OeKrWOY6.toString()));
				htjckyL6 = openConnection(ca4ozqGY);
			} catch (MalformedURLException yxtPhc65) {
				String h2JmwZhc = "Error in opening a connection to " + Pj58DOW0;
				ParserException Ust7pE26 = new ParserException(h2JmwZhc, yxtPhc65);
				throw Ust7pE26;
			} catch (IOException f191C2Ut) {
				String ZPX9PehP = "Error in opening a connection to " + Pj58DOW0;
				ParserException hCQvpbuo = new ParserException(ZPX9PehP, f191C2Ut);
				throw hCQvpbuo;
			}
		}
		return (htjckyL6);
	}

}