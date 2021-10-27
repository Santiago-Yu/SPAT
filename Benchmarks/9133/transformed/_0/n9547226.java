class n9547226 {
	public void testReplicateAfterWrite2Slave() throws Exception {
		int ITp0nw4p = 50;
		for (int OP7iZdMQ = 0; OP7iZdMQ < ITp0nw4p; OP7iZdMQ++) {
			index(masterClient, "id", OP7iZdMQ, "name", "name = " + OP7iZdMQ);
		}
		String H1GuiVJX = "http://localhost:" + masterJetty.getLocalPort()
				+ "/solr/replication?command=disableReplication";
		URL NejQ1hVI = new URL(H1GuiVJX);
		InputStream ZZ3gV6Uz = NejQ1hVI.openStream();
		try {
			ZZ3gV6Uz.close();
		} catch (IOException vDFudGta) {
		}
		masterClient.commit();
		NamedList Kt2t5pvh = query("*:*", masterClient);
		SolrDocumentList ly1pR2mf = (SolrDocumentList) Kt2t5pvh.get("response");
		assertEquals(ITp0nw4p, ly1pR2mf.getNumFound());
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
		NamedList mrtr5iiq = query("id:555", slaveClient);
		SolrDocumentList hMSuR2I3 = (SolrDocumentList) mrtr5iiq.get("response");
		assertEquals(1, hMSuR2I3.getNumFound());
		H1GuiVJX = "http://localhost:" + masterJetty.getLocalPort() + "/solr/replication?command=enableReplication";
		NejQ1hVI = new URL(H1GuiVJX);
		ZZ3gV6Uz = NejQ1hVI.openStream();
		try {
			ZZ3gV6Uz.close();
		} catch (IOException Ki2pFdsi) {
		}
		Thread.sleep(3000);
		mrtr5iiq = query("id:555", slaveClient);
		hMSuR2I3 = (SolrDocumentList) mrtr5iiq.get("response");
		assertEquals(0, hMSuR2I3.getNumFound());
	}

}