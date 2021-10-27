class n14757689 {
	protected Collection<BibtexEntry> getBibtexEntries(String QtWtEJB8, String q9lSxiDq) throws IOException {
		try {
			URL ES08A1Ri = new URL(URL_BIBTEX);
			URLConnection XlQ7fqzT = ES08A1Ri.openConnection();
			XlQ7fqzT.setRequestProperty("Cookie", QtWtEJB8 + "; " + q9lSxiDq);
			XlQ7fqzT.connect();
			BibtexParser iHCDBipV = new BibtexParser(
					new BufferedReader(new InputStreamReader(XlQ7fqzT.getInputStream())));
			return iHCDBipV.parse().getDatabase().getEntries();
		} catch (MalformedURLException bXtUTQAO) {
			throw new RuntimeException(bXtUTQAO);
		}
	}

}