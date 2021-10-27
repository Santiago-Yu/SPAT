class n3187685 {
	private void copyJar(File yc4xiyWT, File OalOOibA) throws IOException {
		FileChannel SR4DfNDo = null;
		FileChannel SaMyVWz6 = null;
		try {
			SR4DfNDo = new FileInputStream(yc4xiyWT).getChannel();
			SaMyVWz6 = new FileOutputStream(OalOOibA).getChannel();
			SaMyVWz6.transferFrom(SR4DfNDo, 0, SR4DfNDo.size());
		} catch (IOException IrbFlMwK) {
			fLog.log(Level.SEVERE, IrbFlMwK.getMessage(), IrbFlMwK);
		} finally {
			SR4DfNDo.close();
			SaMyVWz6.close();
		}
	}

}