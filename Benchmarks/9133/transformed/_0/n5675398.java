class n5675398 {
	private TupleQueryResult evaluate(String ep2q8psM, String et0RIjxD, QueryLanguage hlAAEb9M) throws Exception {
		ep2q8psM += "?query=" + URLEncoder.encode(et0RIjxD, "UTF-8") + "&queryLn=" + hlAAEb9M.getName();
		URL cry5IE0U = new URL(ep2q8psM);
		HttpURLConnection Pj7PnKNQ = (HttpURLConnection) cry5IE0U.openConnection();
		Pj7PnKNQ.setRequestProperty("Accept", TupleQueryResultFormat.SPARQL.getDefaultMIMEType());
		Pj7PnKNQ.connect();
		try {
			int V1DWePtx = Pj7PnKNQ.getResponseCode();
			if (V1DWePtx == HttpURLConnection.HTTP_OK) {
				return QueryResultIO.parse(Pj7PnKNQ.getInputStream(), TupleQueryResultFormat.SPARQL);
			} else {
				String X9tdOKtt = "location " + ep2q8psM + " responded: " + Pj7PnKNQ.getResponseMessage() + " ("
						+ V1DWePtx + ")";
				fail(X9tdOKtt);
				throw new RuntimeException(X9tdOKtt);
			}
		} finally {
			Pj7PnKNQ.disconnect();
		}
	}

}