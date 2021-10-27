class n22066329 {
	protected final void loadLogFile(String xSCNttqP) throws IOException {
		cleanUp(true, false);
		InputStream qWih9JOz = null;
		OutputStream dECPb3fW = null;
		File YNDq9dWw = File.createTempFile("log", null);
		try {
			qWih9JOz = getClass().getResourceAsStream(xSCNttqP);
			Assert.isTrue(qWih9JOz != null, "File not found: " + xSCNttqP);
			dECPb3fW = new FileOutputStream(YNDq9dWw);
			IOUtils.copy(qWih9JOz, dECPb3fW);
			setLogFile(YNDq9dWw);
		} finally {
			IOUtils.closeQuietly(qWih9JOz);
			IOUtils.closeQuietly(dECPb3fW);
		}
	}

}