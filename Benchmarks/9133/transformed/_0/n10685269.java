class n10685269 {
	public static void copy(FileInputStream FtCskgdn, FileOutputStream QBvRcUuk) throws IOException {
		FileChannel mLdXWVnq = FtCskgdn.getChannel();
		FileChannel Xn5DgcIZ = QBvRcUuk.getChannel();
		mLdXWVnq.transferTo(0, mLdXWVnq.size(), Xn5DgcIZ);
		mLdXWVnq.close();
		Xn5DgcIZ.close();
	}

}