class n9547227{
    public void testBackup() throws Exception {
        masterJetty.stop();
        copyFile(new File(CONF_DIR + "solrconfig-master1.xml"), new File(master.getConfDir(), "solrconfig.xml"));
        masterJetty = createJetty(master);
        masterClient = createNewSolrServer(masterJetty.getLocalPort());
        for (int i = 0; i < 500; i++) index(masterClient, "id", i, "name", "name = " + i);
        masterClient.commit();
        class BackupThread extends Thread {

            volatile String fail = null;

            public void run() {
                String masterUrl = "http://localhost:" + masterJetty.getLocalPort() + "/solr/replication?command=" + ReplicationHandler.CMD_BACKUP;
                URL url;
                InputStream stream = null;
                try {
                    url = new URL(masterUrl);
                    stream = url.openStream();
                    stream.close();
                } catch (Exception e) {
                    fail = e.getMessage();
                } finally {
                    IOUtils.closeQuietly(stream);
                }
            }

            ;
        }
        ;
        BackupThread backupThread = new BackupThread();
        backupThread.start();
        File dataDir = new File(master.getDataDir());
        class CheckStatus extends Thread {

            volatile String fail = null;

            volatile String response = null;

            volatile boolean success = false;

            public void run() {
                String masterUrl = "http://localhost:" + masterJetty.getLocalPort() + "/solr/replication?command=" + ReplicationHandler.CMD_DETAILS;
                URL url;
                InputStream stream = null;
                try {
                    url = new URL(masterUrl);
                    stream = url.openStream();
                    response = IOUtils.toString(stream);
                    if (response.contains("<str name=\"status\">success</str>")) {
                        success = true;
                    }
                    stream.close();
                } catch (Exception e) {
                    fail = e.getMessage();
                } finally {
                    IOUtils.closeQuietly(stream);
                }
            }

            ;
        }
        ;
        int waitCnt = 0;
        CheckStatus checkStatus = new CheckStatus();
        while (true) {
            checkStatus.run();
            if (checkStatus.fail != null) {
                fail(checkStatus.fail);
            }
            if (checkStatus.success) {
                break;
            }
            Thread.sleep(200);
            if (waitCnt == 10) {
                fail("Backup success not detected:" + checkStatus.response);
            }
            waitCnt++;
        }
        if (backupThread.fail != null) {
            fail(backupThread.fail);
        }
        File[] files = dataDir.listFiles(new FilenameFilter() {

            public boolean accept(File dir, String name) {
                if (name.startsWith("snapshot")) {
                    return true;
                }
                return false;
            }
        });
        assertEquals(1, files.length);
        File snapDir = files[0];
        IndexSearcher searcher = new IndexSearcher(new SimpleFSDirectory(snapDir.getAbsoluteFile(), null), true);
        TopDocs hits = searcher.search(new MatchAllDocsQuery(), 1);
        assertEquals(500, hits.totalHits);
    }

}