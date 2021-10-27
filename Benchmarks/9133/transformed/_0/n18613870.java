class n18613870 {
	private static void copyFile(File j9WkyDpE, File aCHlSHcy) throws IOException {
		FileChannel UTuzrmWC = new FileInputStream(j9WkyDpE).getChannel();
		FileChannel wk6Cp29O = new FileOutputStream(aCHlSHcy).getChannel();
		UTuzrmWC.transferTo(0, UTuzrmWC.size(), wk6Cp29O);
		UTuzrmWC.close();
		wk6Cp29O.close();
	}

}