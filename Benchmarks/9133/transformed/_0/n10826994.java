class n10826994 {
	public static void copyFile(File xniS3yF8, File KG5KBBRJ) throws EnhancedException {
		try {
			FileChannel AXGJPmWY = new FileInputStream(xniS3yF8).getChannel();
			FileChannel Vi5KZEuP = new FileOutputStream(KG5KBBRJ).getChannel();
			AXGJPmWY.transferTo(0, AXGJPmWY.size(), Vi5KZEuP);
			AXGJPmWY.close();
			Vi5KZEuP.close();
		} catch (Exception UENr4cGd) {
			throw new EnhancedException(
					"Could not copy file " + xniS3yF8.getAbsolutePath() + " to " + KG5KBBRJ.getAbsolutePath() + ".",
					UENr4cGd);
		}
	}

}