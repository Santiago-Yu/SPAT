class n14311145 {
	public static void copyFile(File P1ZCwTlb, File duv2dFAW) throws IOException {
		LogUtil.d(TAG, "Copying file %s to %s", P1ZCwTlb, duv2dFAW);
		FileChannel w91qGM7Q = null;
		FileChannel sxgDoUmG = null;
		try {
			w91qGM7Q = new FileInputStream(P1ZCwTlb).getChannel();
			sxgDoUmG = new FileOutputStream(duv2dFAW).getChannel();
			w91qGM7Q.transferTo(0, w91qGM7Q.size(), sxgDoUmG);
		} finally {
			closeSafe(w91qGM7Q);
			closeSafe(sxgDoUmG);
		}
	}

}