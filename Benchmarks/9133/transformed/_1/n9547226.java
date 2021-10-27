class n9547226 {
	public void testReplicateAfterWrite2Slave() throws Exception {
		int nDocs = 50;
		int obUQE = 0;
		while (obUQE < nDocs) {
			index(masterClient, "id", obUQE, "name", "name = " + obUQE);
			obUQE++;
		}
		String masterUrl = "http://localhost:" + masterJetty.getLocalPort()
				+ "/solr/replication?command=disableReplication";
		URL url = new URL(masterUrl);
		InputStream stream = url.openStream();
		try {
			stream.close();
		} catch (IOException e) {
		}
		masterClient.commit();
		NamedList masterQueryRsp = query("*:*", masterClient);
		SolrDocumentList masterQueryResult = (SolrDocumentList) masterQueryRsp.get("response");
		assertEquals(nDocs, masterQueryResult.getNumFound());
		Thread.sleep(100);
		index(slaveClient, "id", 551, "name", "name = " + 551);
		slaveClient.commit(true, true);
		index(slaveClient, "id", 552, "name", "name = " + 552);
		slaveClient.commit(true, true);
		index(slaveClient, "id", 553, "name", "name = " + 553);
		slaveClient.commit(true, true);
		index(slaveClient, "id", 554, "name", "name = " + 554);
		slaveClient.commit(true, true);
		index(slaveClient, "id", 555, "name", "name = " + 555);
		slaveClient.commit(true, true);
		NamedList slaveQueryRsp = query("id:555", slaveClient);
		SolrDocumentList slaveQueryResult = (SolrDocumentList) slaveQueryRsp.get("response");
		assertEquals(1, slaveQueryResult.getNumFound());
		masterUrl = "http://localhost:" + masterJetty.getLocalPort() + "/solr/replication?command=enableReplication";
		url = new URL(masterUrl);
		stream = url.openStream();
		try {
			stream.close();
		} catch (IOException e) {
		}
		Thread.sleep(3000);
		slaveQueryRsp = query("id:555", slaveClient);
		slaveQueryResult = (SolrDocumentList) slaveQueryRsp.get("response");
		assertEquals(0, slaveQueryResult.getNumFound());
	}

}