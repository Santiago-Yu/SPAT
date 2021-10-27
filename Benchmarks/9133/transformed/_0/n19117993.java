class n19117993 {
	public static final void copyFile(File gdVLplrg, File Gb9zUjaz) throws IOException {
		FileChannel bzGBCMAB = new FileInputStream(gdVLplrg).getChannel();
		FileChannel kxBPFXQ7 = new FileOutputStream(Gb9zUjaz).getChannel();
		try {
			kxBPFXQ7.transferFrom(bzGBCMAB, 0, bzGBCMAB.size());
		} finally {
			bzGBCMAB.close();
			kxBPFXQ7.close();
		}
	}

}