class n3667136 {
	public void fileCopy2(File i5d8vNOm, File KQU1ooFR) throws Exception {
		try {
			FileChannel NjDsORGC = new FileInputStream(i5d8vNOm).getChannel();
			FileChannel h5a3vN57 = new FileOutputStream(KQU1ooFR).getChannel();
			h5a3vN57.transferFrom(NjDsORGC, 0, NjDsORGC.size());
			NjDsORGC.close();
			h5a3vN57.close();
		} catch (IOException H6gDibhv) {
			throw new Exception("Could not copy file: " + i5d8vNOm.getName());
		}
	}

}