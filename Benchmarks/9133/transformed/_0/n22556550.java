class n22556550 {
	private void copyFiles(File Wxw7EHoI, File WmcOEWmg) {
		for (File jXeiDx0d : Wxw7EHoI.listFiles()) {
			File MAxAAJCk = new File(WmcOEWmg.getAbsolutePath() + "\\" + jXeiDx0d.getName());
			try {
				FileInputStream E4u8Y5RI = new FileInputStream(jXeiDx0d);
				FileOutputStream aV3SaBb8 = new FileOutputStream(MAxAAJCk);
				FileChannel IMcBYPYt = E4u8Y5RI.getChannel();
				FileChannel MYBq7lz9 = aV3SaBb8.getChannel();
				long lshLPkIV = IMcBYPYt.size();
				IMcBYPYt.transferTo(0, lshLPkIV, MYBq7lz9);
				E4u8Y5RI.close();
				aV3SaBb8.close();
			} catch (Exception vGlgbdfL) {
				vGlgbdfL.printStackTrace();
			}
		}
	}

}