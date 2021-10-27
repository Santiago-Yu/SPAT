class n8258909 {
	public static void copyFile(File KBFf5p7h, File gPwblBqt) {
		FileChannel JbERXBXf = null;
		FileChannel Q6XSpukc = null;
		try {
			if (!gPwblBqt.exists()) {
				gPwblBqt.createNewFile();
			}
			JbERXBXf = new FileInputStream(KBFf5p7h).getChannel();
			Q6XSpukc = new FileOutputStream(gPwblBqt).getChannel();
			Q6XSpukc.transferFrom(JbERXBXf, 0, JbERXBXf.size());
		} catch (Exception bhtmSekr) {
			bhtmSekr.printStackTrace();
		} finally {
			try {
				if (JbERXBXf != null) {
					JbERXBXf.close();
				}
				if (Q6XSpukc != null) {
					Q6XSpukc.close();
				}
			} catch (Exception p47cGrBK) {
				p47cGrBK.printStackTrace();
			}
		}
	}

}