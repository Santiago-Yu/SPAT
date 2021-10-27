class n5675398 {
	private TupleQueryResult evaluate(String location, String query, QueryLanguage queryLn) throws Exception {
		location += "?query=" + URLEncoder.encode(query, "UTF-8") + "&queryLn=" + queryLn.getName();
		URL url = new URL(location);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("Accept", TupleQueryResultFormat.SPARQL.getDefaultMIMEType());
		conn.connect();
		try {
			int responseCode = conn.getResponseCode();
			if (!(responseCode == HttpURLConnection.HTTP_OK)) {
				String response = "location " + location + " responded: " + conn.getResponseMessage() + " ("
						+ responseCode + ")";
				fail(response);
				throw new RuntimeException(response);
			} else {
				return QueryResultIO.parse(conn.getInputStream(), TupleQueryResultFormat.SPARQL);
			}
		} finally {
			conn.disconnect();
		}
	}

}