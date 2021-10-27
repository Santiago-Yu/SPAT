class n9547224{
    public void testSnapPullWithMasterUrl() throws Exception {
        copyFile(new File(CONF_DIR + "solrconfig-slave1.xml"), new File(slave.getConfDir(), "solrconfig.xml"));
        slaveJetty.stop();
        slaveJetty = createJetty(slave);
        slaveClient = createNewSolrServer(slaveJetty.getLocalPort());
        for (int i = 0; i < 500; i++) index(masterClient, "id", i, "name", "name = " + i);
        masterClient.commit();
        NamedList masterQueryRsp = query("*:*", masterClient);
        SolrDocumentList masterQueryResult = (SolrDocumentList) masterQueryRsp.get("response");
        assertEquals(500, masterQueryResult.getNumFound());
        String masterUrl = "http://localhost:" + slaveJetty.getLocalPort() + "/solr/replication?command=fetchindex&masterUrl=";
        masterUrl += "http://localhost:" + masterJetty.getLocalPort() + "/solr/replication";
        URL url = new URL(masterUrl);
        InputStream stream = url.openStream();
        try {
            stream.close();
        } catch (IOException e) {
        }
        Thread.sleep(3000);
        NamedList slaveQueryRsp = query("*:*", slaveClient);
        SolrDocumentList slaveQueryResult = (SolrDocumentList) slaveQueryRsp.get("response");
        assertEquals(500, slaveQueryResult.getNumFound());
        String cmp = TestDistributedSearch.compare(masterQueryResult, slaveQueryResult, 0, null);
        assertEquals(null, cmp);
    }

}