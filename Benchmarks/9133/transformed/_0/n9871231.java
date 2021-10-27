class n9871231 {
	private void copy(File tqsdH1Yc, File XJqlojXd) {
		try {
			FileChannel tFDdwfnG = new FileInputStream(tqsdH1Yc).getChannel();
			FileChannel DiW9Y0H1 = new FileOutputStream(XJqlojXd).getChannel();
			try {
				tFDdwfnG.transferTo(0, tFDdwfnG.size(), DiW9Y0H1);
				tFDdwfnG.close();
				DiW9Y0H1.close();
			} catch (IOException qYd4upNz) {
				GTLogger.getInstance().error(qYd4upNz);
			}
		} catch (FileNotFoundException wSGqN2my) {
			GTLogger.getInstance().error(wSGqN2my);
		}
	}

}