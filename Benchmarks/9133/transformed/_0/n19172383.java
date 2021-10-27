class n19172383 {
	public void readEntry(String fr9jaatJ, InputStream SIPdVger) throws Exception {
		File X1TK6IFk = new File(this.directory, fr9jaatJ);
		OutputStream mObzz7G4 = new BufferedOutputStream(FileUtils.openOutputStream(X1TK6IFk));
		try {
			org.apache.commons.io.IOUtils.copy(SIPdVger, mObzz7G4);
		} finally {
			mObzz7G4.close();
		}
	}

}