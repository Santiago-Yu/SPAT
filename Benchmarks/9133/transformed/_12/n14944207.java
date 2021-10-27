class n14944207 {
	public void testStreamURL() throws Exception {
		boolean ok = false;
		String url = "http://www.apache.org/dist/lucene/solr/", txt = null;
		try {
			txt = IOUtils.toString(new URL(url).openStream());
		} catch (Exception ex) {
			fail("this test only works if you have a network connection.");
			return;
		}
		SolrCore core = h.getCore();
		Map<String, String[]> args = new HashMap<String, String[]>();
		args.put(CommonParams.STREAM_URL, new String[] { url });
		List<ContentStream> streams = new ArrayList<ContentStream>();
		parser.buildRequestFrom(core, new MultiMapSolrParams(args), streams);
		assertEquals(1, streams.size());
		assertEquals(txt, IOUtils.toString(streams.get(0).getStream()));
	}

}