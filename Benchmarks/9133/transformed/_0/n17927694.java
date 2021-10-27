class n17927694 {
	public static void copyFile(FileInputStream bRl3iGv8, FileOutputStream g04uK6Gh) throws Exception {
		FileChannel WDcsvHN2 = bRl3iGv8.getChannel();
		FileChannel M4DLxpkw = g04uK6Gh.getChannel();
		try {
			WDcsvHN2.transferTo(0, WDcsvHN2.size(), M4DLxpkw);
		} catch (IOException laoQmGaR) {
			throw laoQmGaR;
		} finally {
			if (WDcsvHN2 != null)
				WDcsvHN2.close();
			if (M4DLxpkw != null)
				M4DLxpkw.close();
		}
	}

}