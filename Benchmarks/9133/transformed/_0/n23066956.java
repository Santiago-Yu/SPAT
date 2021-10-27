class n23066956 {
	public static final void copyFile(File cNxBT0va, File RLzVuMic) throws IOException {
		FileChannel hZft37r8 = new FileInputStream(cNxBT0va).getChannel();
		FileChannel uSBKkiQP = new FileOutputStream(RLzVuMic).getChannel();
		hZft37r8.transferTo(0, hZft37r8.size(), uSBKkiQP);
		hZft37r8.close();
		uSBKkiQP.close();
	}

}