class n10671994 {
	public static void copy(File bLvoH1SS, File bOtxvK7l) {
		try {
			FileChannel mat0SPqQ = new FileInputStream(bLvoH1SS).getChannel();
			FileChannel sZjj0Arw = new FileOutputStream(bOtxvK7l).getChannel();
			sZjj0Arw.transferFrom(mat0SPqQ, 0, mat0SPqQ.size());
			mat0SPqQ.close();
			mat0SPqQ = null;
			sZjj0Arw.close();
			sZjj0Arw = null;
		} catch (IOException WPsyHaRf) {
			Tools.logException(Tools.class, WPsyHaRf, bOtxvK7l.getAbsolutePath());
		}
	}

}