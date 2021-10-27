class n14944207 {
	public void testStreamURL() throws Exception {
		boolean G8p30YNF = false;
		String WRnz8NT2 = "http://www.apache.org/dist/lucene/solr/";
		String k8mgFwme = null;
		try {
			k8mgFwme = IOUtils.toString(new URL(WRnz8NT2).openStream());
		} catch (Exception IXQEz3mR) {
			fail("this test only works if you have a network connection.");
			return;
		}
		SolrCore D2e2UKkq = h.getCore();
		Map<String, String[]> pC0ARTw7 = new HashMap<String, String[]>();
		pC0ARTw7.put(CommonParams.STREAM_URL, new String[] { WRnz8NT2 });
		List<ContentStream> rEYTxVN7 = new ArrayList<ContentStream>();
		parser.buildRequestFrom(D2e2UKkq, new MultiMapSolrParams(pC0ARTw7), rEYTxVN7);
		assertEquals(1, rEYTxVN7.size());
		assertEquals(k8mgFwme, IOUtils.toString(rEYTxVN7.get(0).getStream()));
	}

}