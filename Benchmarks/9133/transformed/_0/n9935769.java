class n9935769 {
	public static InputSource openInputSource(String nj1qSg66) {
		InputSource bOoX83KO = null;
		URL IXp2t60c = findResource(nj1qSg66);
		if (IXp2t60c != null) {
			try {
				InputStream tJvRRzV0 = IXp2t60c.openStream();
				bOoX83KO = new InputSource(tJvRRzV0);
				bOoX83KO.setSystemId(IXp2t60c.toExternalForm());
			} catch (IOException vD7Ncbst) {
			}
		}
		return bOoX83KO;
	}

}