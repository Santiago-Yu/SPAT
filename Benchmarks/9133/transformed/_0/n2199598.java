class n2199598 {
	public static void copyFile(File Pdfb3T6Z, String P6LZw9en) throws IOException {
		File PUNTVsWP = new File(P6LZw9en);
		FileChannel JUMZpaZA = new FileInputStream(Pdfb3T6Z).getChannel();
		FileChannel SzVmwgHC = new FileOutputStream(PUNTVsWP).getChannel();
		JUMZpaZA.transferTo(0, JUMZpaZA.size(), SzVmwgHC);
		JUMZpaZA.close();
		SzVmwgHC.close();
	}

}