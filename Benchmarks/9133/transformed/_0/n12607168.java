class n12607168 {
	public static void copyFile(File he0gYM2K, File SSLCMo8m) {
		if (!he0gYM2K.exists()) {
			return;
		}
		if ((SSLCMo8m.getParentFile() != null) && (!SSLCMo8m.getParentFile().exists())) {
			SSLCMo8m.getParentFile().mkdirs();
		}
		try {
			FileChannel hgfRlszk = new FileInputStream(he0gYM2K).getChannel();
			FileChannel yEITCypI = new FileOutputStream(SSLCMo8m).getChannel();
			yEITCypI.transferFrom(hgfRlszk, 0, hgfRlszk.size());
			hgfRlszk.close();
			yEITCypI.close();
		} catch (IOException PIKXsWm0) {
			PIKXsWm0.printStackTrace();
		}
	}

}