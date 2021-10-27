class n9872510 {
	private static String makeTempTraceFile(String zwK1wZf2) throws IOException {
		File kazM8MNV = File.createTempFile(zwK1wZf2, ".trace");
		kazM8MNV.deleteOnExit();
		FileChannel mCH3bo8C = new FileOutputStream(kazM8MNV).getChannel();
		FileChannel mDONzuVH = new FileInputStream(zwK1wZf2 + ".key").getChannel();
		long rdFMHPOm = mCH3bo8C.transferFrom(mDONzuVH, 0, mDONzuVH.size());
		mDONzuVH.close();
		mDONzuVH = new FileInputStream(zwK1wZf2 + ".data").getChannel();
		mCH3bo8C.transferFrom(mDONzuVH, rdFMHPOm, mDONzuVH.size());
		mDONzuVH.close();
		mCH3bo8C.close();
		return kazM8MNV.getPath();
	}

}