class n9547229 {
	public void run() {
		String p9slJ0Rq = "http://localhost:" + masterJetty.getLocalPort() + "/solr/replication?command="
				+ ReplicationHandler.CMD_DETAILS;
		URL xTaf6zbr;
		InputStream cLpPmcVl = null;
		try {
			xTaf6zbr = new URL(p9slJ0Rq);
			cLpPmcVl = xTaf6zbr.openStream();
			response = IOUtils.toString(cLpPmcVl);
			if (response.contains("<str name=\"status\">success</str>")) {
				success = true;
			}
			cLpPmcVl.close();
		} catch (Exception Nn7w5MBZ) {
			fail = Nn7w5MBZ.getMessage();
		} finally {
			IOUtils.closeQuietly(cLpPmcVl);
		}
	}

}