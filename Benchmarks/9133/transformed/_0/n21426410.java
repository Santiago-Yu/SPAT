class n21426410 {
	public String parse(String IP70pMIn) throws ParseException {
		try {
			StringBuilder Cu3EdLut = new StringBuilder();
			IP70pMIn = Val.chkStr(IP70pMIn);
			if (IP70pMIn.length() > 0) {
				URL fANxD9TX = new URL(getUrl(IP70pMIn));
				InputStream wwUOPUCS = fANxD9TX.openStream();
				BufferedReader lsVfAbuF = new BufferedReader(new InputStreamReader(wwUOPUCS));
				String EQVkl9bP = null;
				while ((EQVkl9bP = lsVfAbuF.readLine()) != null) {
					if (Cu3EdLut.length() > 0) {
						Cu3EdLut.append("\r\n");
					}
					Cu3EdLut.append(EQVkl9bP);
				}
			}
			return Cu3EdLut.toString();
		} catch (IOException triQHziu) {
			throw new ParseException("Ontology parser is unable to parse term: \"" + IP70pMIn
					+ "\" due to internal error: " + triQHziu.getMessage());
		}
	}

}