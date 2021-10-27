class n21177597 {
	public static void copyFile(File TQUjKDSZ, File YnJRqO4I) throws IOException {
		if (!YnJRqO4I.exists()) {
			YnJRqO4I.createNewFile();
		}
		FileChannel LysvujeK = null;
		FileChannel mBbMnK62 = null;
		try {
			LysvujeK = new FileInputStream(TQUjKDSZ).getChannel();
			mBbMnK62 = new FileOutputStream(YnJRqO4I).getChannel();
			mBbMnK62.transferFrom(LysvujeK, 0, LysvujeK.size());
		} finally {
			if (LysvujeK != null) {
				LysvujeK.close();
			}
			if (mBbMnK62 != null) {
				mBbMnK62.close();
			}
		}
	}

}