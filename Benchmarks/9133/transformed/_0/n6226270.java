class n6226270 {
	public static void copyFile(File pxI9LNUt, File juuTtK2O) {
		try {
			FileChannel nIqRM4Dk = new FileInputStream(pxI9LNUt).getChannel();
			FileChannel POjzl00Y = new FileOutputStream(juuTtK2O).getChannel();
			nIqRM4Dk.transferTo(0, nIqRM4Dk.size(), POjzl00Y);
			nIqRM4Dk.close();
			POjzl00Y.close();
		} catch (FileNotFoundException ztvQu5V9) {
			ztvQu5V9.printStackTrace();
		} catch (IOException maJ3dbMl) {
			maJ3dbMl.printStackTrace();
		}
	}

}