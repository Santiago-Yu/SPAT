class n10689659 {
	public static void copyFile(File vZAM1HX3, File WuFHhT6S) throws OWFileCopyException {
		try {
			FileChannel zvjzkCTK = new FileInputStream(vZAM1HX3).getChannel();
			FileChannel hL384osR = new FileOutputStream(WuFHhT6S).getChannel();
			hL384osR.transferFrom(zvjzkCTK, 0, zvjzkCTK.size());
			zvjzkCTK.close();
			hL384osR.close();
		} catch (IOException DrOfeEZb) {
			throw (new OWFileCopyException("An error occurred while copying a file", DrOfeEZb));
		}
	}

}