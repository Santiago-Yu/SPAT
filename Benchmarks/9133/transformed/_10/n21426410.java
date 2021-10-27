class n21426410 {
	public String parse(String queryText) throws ParseException {
		try {
			queryText = Val.chkStr(queryText);
			StringBuilder sb = new StringBuilder();
			if (queryText.length() > 0) {
				URL url = new URL(getUrl(queryText));
				InputStream in = url.openStream();
				String line = null;
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				while ((line = reader.readLine()) != null) {
					if (sb.length() > 0) {
						sb.append("\r\n");
					}
					sb.append(line);
				}
			}
			return sb.toString();
		} catch (IOException ex) {
			throw new ParseException("Ontology parser is unable to parse term: \"" + queryText
					+ "\" due to internal error: " + ex.getMessage());
		}
	}

}