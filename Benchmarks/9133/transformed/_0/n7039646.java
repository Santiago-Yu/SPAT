class n7039646 {
	private static final void cloneFile(File yjSfcsgx, File KrQmF6Xi) throws IOException {
		FileChannel M5Ye6Zfp = null;
		FileChannel hiQbvicw = null;
		try {
			M5Ye6Zfp = new FileInputStream(yjSfcsgx).getChannel();
			hiQbvicw = new FileOutputStream(KrQmF6Xi).getChannel();
			hiQbvicw.transferFrom(M5Ye6Zfp, 0, M5Ye6Zfp.size());
		} finally {
			if (M5Ye6Zfp != null)
				M5Ye6Zfp.close();
			if (hiQbvicw != null)
				hiQbvicw.close();
		}
	}

}