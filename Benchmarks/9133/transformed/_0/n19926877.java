class n19926877 {
	@Override
	public void createCopy(File IATI5QCB, File mHhU3Ni2) throws IOException {
		FileChannel iwI6UOpP = null;
		FileChannel qoDymbVc = null;
		try {
			iwI6UOpP = new FileInputStream(IATI5QCB).getChannel();
			qoDymbVc = new FileOutputStream(mHhU3Ni2).getChannel();
			qoDymbVc.transferFrom(iwI6UOpP, 0, iwI6UOpP.size());
		} finally {
			if (iwI6UOpP != null) {
				iwI6UOpP.close();
			}
			if (qoDymbVc != null) {
				qoDymbVc.close();
			}
		}
	}

}