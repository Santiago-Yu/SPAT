class n9547224 {
	public void testSnapPullWithMasterUrl() throws Exception {
		copyFile(new File(CONF_DIR + "solrconfig-slave1.xml"), new File(slave.getConfDir(), "solrconfig.xml"));
		slaveJetty.stop();
		slaveJetty = createJetty(slave);
		slaveClient = createNewSolrServer(slaveJetty.getLocalPort());
		for (int kl2jjOtk = 0; kl2jjOtk < 500; kl2jjOtk++)
			index(masterClient, "id", kl2jjOtk, "name", "name = " + kl2jjOtk);
		masterClient.commit();
		NamedList NIpsDiNx = query("*:*", masterClient);
		SolrDocumentList BruCSZQJ = (SolrDocumentList) NIpsDiNx.get("response");
		assertEquals(500, BruCSZQJ.getNumFound());
		String lO0teh9B = "http://localhost:" + slaveJetty.getLocalPort()
				+ "/solr/replication?command=fetchindex&masterUrl=";
		lO0teh9B += "http://localhost:" + masterJetty.getLocalPort() + "/solr/replication";
		URL ke6E5tP5 = new URL(lO0teh9B);
		InputStream WHsymzSH = ke6E5tP5.openStream();
		try {
			WHsymzSH.close();
		} catch (IOException QGA5TvGp) {
		}
		Thread.sleep(3000);
		NamedList qNEm7IPG = query("*:*", slaveClient);
		SolrDocumentList XxJlwUHU = (SolrDocumentList) qNEm7IPG.get("response");
		assertEquals(500, XxJlwUHU.getNumFound());
		String apmYBrgv = TestDistributedSearch.compare(BruCSZQJ, XxJlwUHU, 0, null);
		assertEquals(null, apmYBrgv);
	}

}