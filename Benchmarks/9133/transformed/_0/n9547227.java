class n9547227 {
	public void testBackup() throws Exception {
		masterJetty.stop();
		copyFile(new File(CONF_DIR + "solrconfig-master1.xml"), new File(master.getConfDir(), "solrconfig.xml"));
		masterJetty = createJetty(master);
		masterClient = createNewSolrServer(masterJetty.getLocalPort());
		for (int JiGZ0J0G = 0; JiGZ0J0G < 500; JiGZ0J0G++)
			index(masterClient, "id", JiGZ0J0G, "name", "name = " + JiGZ0J0G);
		masterClient.commit();
		class BackupThread extends Thread {

			volatile String MKdqKGsN = null;

			public void run() {
				String CmeKvS2L = "http://localhost:" + masterJetty.getLocalPort() + "/solr/replication?command="
						+ ReplicationHandler.CMD_BACKUP;
				URL RxyhILOv;
				InputStream Nb2Ye6EM = null;
				try {
					RxyhILOv = new URL(CmeKvS2L);
					Nb2Ye6EM = RxyhILOv.openStream();
					Nb2Ye6EM.close();
				} catch (Exception wVoRqPM6) {
					MKdqKGsN = wVoRqPM6.getMessage();
				} finally {
					IOUtils.closeQuietly(Nb2Ye6EM);
				}
			}

			;
		}
		;
		BackupThread A0TYhC24 = new BackupThread();
		A0TYhC24.start();
		File S7GpAI3v = new File(master.getDataDir());
		class CheckStatus extends Thread {

			volatile String P0cmZwGD = null;

			volatile String Xv0D4q9V = null;

			volatile boolean XMkWlThW = false;

			public void run() {
				String OM8fCWvr = "http://localhost:" + masterJetty.getLocalPort() + "/solr/replication?command="
						+ ReplicationHandler.CMD_DETAILS;
				URL npzzCvrF;
				InputStream bIyPBgNO = null;
				try {
					npzzCvrF = new URL(OM8fCWvr);
					bIyPBgNO = npzzCvrF.openStream();
					Xv0D4q9V = IOUtils.toString(bIyPBgNO);
					if (Xv0D4q9V.contains("<str name=\"status\">success</str>")) {
						XMkWlThW = true;
					}
					bIyPBgNO.close();
				} catch (Exception ZERv3X4u) {
					P0cmZwGD = ZERv3X4u.getMessage();
				} finally {
					IOUtils.closeQuietly(bIyPBgNO);
				}
			}

			;
		}
		;
		int kMEG4iKY = 0;
		CheckStatus UjmfTqyv = new CheckStatus();
		while (true) {
			UjmfTqyv.run();
			if (UjmfTqyv.P0cmZwGD != null) {
				fail(UjmfTqyv.P0cmZwGD);
			}
			if (UjmfTqyv.XMkWlThW) {
				break;
			}
			Thread.sleep(200);
			if (kMEG4iKY == 10) {
				fail("Backup success not detected:" + UjmfTqyv.Xv0D4q9V);
			}
			kMEG4iKY++;
		}
		if (A0TYhC24.MKdqKGsN != null) {
			fail(A0TYhC24.MKdqKGsN);
		}
		File[] n6qVEF1N = S7GpAI3v.listFiles(new FilenameFilter() {

			public boolean accept(File jvJ6X8gk, String FmZkpsWn) {
				if (FmZkpsWn.startsWith("snapshot")) {
					return true;
				}
				return false;
			}
		});
		assertEquals(1, n6qVEF1N.length);
		File SrENTsVt = n6qVEF1N[0];
		IndexSearcher LQByJIpw = new IndexSearcher(new SimpleFSDirectory(SrENTsVt.getAbsoluteFile(), null), true);
		TopDocs ZmcgTCi2 = LQByJIpw.search(new MatchAllDocsQuery(), 1);
		assertEquals(500, ZmcgTCi2.totalHits);
	}

}