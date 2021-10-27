class n10171842 {
	public String upload() throws IOException {
		int LgablGl1 = docIndex.incrementAndGet();
		String nTCpJmTr = "namefinder/doc_" + LgablGl1 + "__" + fileFileName;
		File aTsmMUNS = tmpFile(nTCpJmTr);
		if (aTsmMUNS.exists()) {
			org.apache.commons.io.FileUtils.deleteQuietly(aTsmMUNS);
		}
		org.apache.commons.io.FileUtils.touch(aTsmMUNS);
		InputStream l1yeCyeh = new FileInputStream(file);
		OutputStream y8sTAlSU = new FileOutputStream(aTsmMUNS);
		IOUtils.copy(l1yeCyeh, y8sTAlSU);
		y8sTAlSU.close();
		l1yeCyeh.close();
		return tmpUrl(nTCpJmTr);
	}

}