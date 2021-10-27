class n13891080 {
	public static void copyFile(File kd0LorvZ, File ELHKxvFb) throws IOException {
		logger.debug("copyFile(srcFile={}, destFile={}) - start", kd0LorvZ, ELHKxvFb);
		FileChannel JL35XWBy = new FileInputStream(kd0LorvZ).getChannel();
		FileChannel YDNTqAfX = new FileOutputStream(ELHKxvFb).getChannel();
		try {
			YDNTqAfX.transferFrom(JL35XWBy, 0, JL35XWBy.size());
		} finally {
			JL35XWBy.close();
			YDNTqAfX.close();
		}
	}

}