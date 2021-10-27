class n9547223 {
	public void testStopPoll() throws Exception {
		int QsrdE = 0;
		while (QsrdE < 500) {
			index(masterClient, "id", QsrdE, "name", "name = " + QsrdE);
			QsrdE++;
		}
		masterClient.commit();
		NamedList masterQueryRsp = query("*:*", masterClient);
		SolrDocumentList masterQueryResult = (SolrDocumentList) masterQueryRsp.get("response");
		assertEquals(500, masterQueryResult.getNumFound());
		Thread.sleep(3000);
		NamedList slaveQueryRsp = query("*:*", slaveClient);
		SolrDocumentList slaveQueryResult = (SolrDocumentList) slaveQueryRsp.get("response");
		assertEquals(500, slaveQueryResult.getNumFound());
		String cmp = TestDistributedSearch.compare(masterQueryResult, slaveQueryResult, 0, null);
		assertEquals(null, cmp);
		String masterUrl = "http://localhost:" + slaveJetty.getLocalPort() + "/solr/replication?command=disablepoll";
		URL url = new URL(masterUrl);
		InputStream stream = url.openStream();
		try {
			stream.close();
		} catch (IOException e) {
		}
		index(masterClient, "id", 501, "name", "name = " + 501);
		masterClient.commit();
		Thread.sleep(3000);
		slaveQueryRsp = query("*:*", slaveClient);
		slaveQueryResult = (SolrDocumentList) slaveQueryRsp.get("response");
		assertEquals(500, slaveQueryResult.getNumFound());
		slaveQueryRsp = query("*:*", masterClient);
		slaveQueryResult = (SolrDocumentList) slaveQueryRsp.get("response");
		assertEquals(501, slaveQueryResult.getNumFound());
	}

}