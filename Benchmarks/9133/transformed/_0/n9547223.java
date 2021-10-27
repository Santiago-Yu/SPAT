class n9547223 {
	public void testStopPoll() throws Exception {
		for (int j3z3i2Zg = 0; j3z3i2Zg < 500; j3z3i2Zg++)
			index(masterClient, "id", j3z3i2Zg, "name", "name = " + j3z3i2Zg);
		masterClient.commit();
		NamedList N05JqQKu = query("*:*", masterClient);
		SolrDocumentList Me7NirrH = (SolrDocumentList) N05JqQKu.get("response");
		assertEquals(500, Me7NirrH.getNumFound());
		Thread.sleep(3000);
		NamedList c3vbBMzi = query("*:*", slaveClient);
		SolrDocumentList x50XzPNs = (SolrDocumentList) c3vbBMzi.get("response");
		assertEquals(500, x50XzPNs.getNumFound());
		String yZB5gQDD = TestDistributedSearch.compare(Me7NirrH, x50XzPNs, 0, null);
		assertEquals(null, yZB5gQDD);
		String NcX2Z5bZ = "http://localhost:" + slaveJetty.getLocalPort() + "/solr/replication?command=disablepoll";
		URL k6EnNtRo = new URL(NcX2Z5bZ);
		InputStream fOV7T12P = k6EnNtRo.openStream();
		try {
			fOV7T12P.close();
		} catch (IOException FLWANa9h) {
		}
		index(masterClient, "id", 501, "name", "name = " + 501);
		masterClient.commit();
		Thread.sleep(3000);
		c3vbBMzi = query("*:*", slaveClient);
		x50XzPNs = (SolrDocumentList) c3vbBMzi.get("response");
		assertEquals(500, x50XzPNs.getNumFound());
		c3vbBMzi = query("*:*", masterClient);
		x50XzPNs = (SolrDocumentList) c3vbBMzi.get("response");
		assertEquals(501, x50XzPNs.getNumFound());
	}

}