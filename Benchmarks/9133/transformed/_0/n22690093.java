class n22690093 {
	private void copy(File SDX9lVih, File nQZBNE2x) {
		try {
			FileChannel e0kfJPUH = new FileInputStream(SDX9lVih).getChannel();
			FileChannel crn9QDRz = new FileOutputStream(nQZBNE2x).getChannel();
			try {
				e0kfJPUH.transferTo(0, e0kfJPUH.size(), crn9QDRz);
				e0kfJPUH.close();
				crn9QDRz.close();
			} catch (IOException JcldxA9g) {
				GTLogger.getInstance().error(JcldxA9g);
			}
		} catch (FileNotFoundException ReesQ3e9) {
			GTLogger.getInstance().error(ReesQ3e9);
		}
	}

}