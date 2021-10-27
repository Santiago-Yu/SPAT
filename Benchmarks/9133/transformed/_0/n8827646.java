class n8827646 {
	@SuppressWarnings("unchecked")
	private List getURLList(String YWVUOoSS) throws IOException {
		List rPihwygt = null;
		try {
			URL jboamNDM = new URL(dbURL + YWVUOoSS);
			URLConnection ebuQbVWN = jboamNDM.openConnection();
			ebuQbVWN.connect();
			JSONParser fS4vbRJM = JSONParser.defaultJSONParser();
			InputStreamSource uwd9AnXh = new InputStreamSource(ebuQbVWN.getInputStream(), true);
			rPihwygt = fS4vbRJM.parse(List.class, uwd9AnXh);
			uwd9AnXh.destroy();
		} catch (MalformedURLException az9RjHXq) {
			System.err.println("Internal malformed url Exception: " + az9RjHXq);
		}
		return rPihwygt;
	}

}