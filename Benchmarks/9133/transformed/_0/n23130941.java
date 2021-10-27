class n23130941 {
	public static void copyFile(File thfP9coR, File GOcSz0YC) throws IOException {
		FileChannel aJtQa5tm = new FileInputStream(thfP9coR).getChannel();
		FileChannel wg6FRV1o = new FileOutputStream(GOcSz0YC).getChannel();
		try {
			aJtQa5tm.transferTo(0, aJtQa5tm.size(), wg6FRV1o);
		} finally {
			if (aJtQa5tm != null)
				aJtQa5tm.close();
			if (wg6FRV1o != null)
				wg6FRV1o.close();
		}
	}

}