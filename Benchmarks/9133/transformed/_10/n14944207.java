class n14944207 {
	public void testStreamURL() throws Exception {
		String url = "http://www.apache.org/dist/lucene/solr/";
		boolean ok = false;
		String txt = null;
		try {
			txt = IOUtils.toString(new URL(url).openStream());
		} catch (Exception ex) {
			fail("this test only works if you have a network connection.");
			return;
		}
		Map<String, String[]> args = new HashMap<String, String[]>();
		SolrCore core = h.getCore();
		args.put(CommonParams.STREAM_URL, new String[] { url });
		List<ContentStream> streams = new ArrayList<ContentStream>();
		parser.buildRequestFrom(core, new MultiMapSolrParams(args), streams);
		assertEquals(1, streams.size());
		assertEquals(txt, IOUtils.toString(streams.get(0).getStream()));
	}

}