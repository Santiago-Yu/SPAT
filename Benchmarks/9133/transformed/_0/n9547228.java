class n9547228 {
	public void run() {
		String c4sdwCUI = "http://localhost:" + masterJetty.getLocalPort() + "/solr/replication?command="
				+ ReplicationHandler.CMD_BACKUP;
		URL OBu46umC;
		InputStream XF3nbcOW = null;
		try {
			OBu46umC = new URL(c4sdwCUI);
			XF3nbcOW = OBu46umC.openStream();
			XF3nbcOW.close();
		} catch (Exception XRSnzNgG) {
			fail = XRSnzNgG.getMessage();
		} finally {
			IOUtils.closeQuietly(XF3nbcOW);
		}
	}

}