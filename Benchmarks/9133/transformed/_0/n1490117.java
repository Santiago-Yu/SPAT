class n1490117 {
	private static void copy(File mfkwXvrH, File WRIfHK4k) throws IOException {
		FileChannel NMaFAqeD = new FileInputStream(mfkwXvrH).getChannel();
		FileChannel yhkFekxA = new FileOutputStream(WRIfHK4k).getChannel();
		NMaFAqeD.transferTo(0, NMaFAqeD.size(), yhkFekxA);
		NMaFAqeD.close();
		yhkFekxA.close();
	}

}