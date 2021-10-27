class n12903179 {
	public static void copyFile(File j9KljqXD, File IWuxH1zP) throws IOException {
		if (!j9KljqXD.exists()) {
			return;
		}
		if (!IWuxH1zP.exists()) {
			IWuxH1zP.createNewFile();
		}
		FileChannel Gbm5XSj7 = null;
		FileChannel MMutRH5U = null;
		Gbm5XSj7 = new FileInputStream(j9KljqXD).getChannel();
		MMutRH5U = new FileOutputStream(IWuxH1zP).getChannel();
		if (MMutRH5U != null && Gbm5XSj7 != null) {
			MMutRH5U.transferFrom(Gbm5XSj7, 0, Gbm5XSj7.size());
		}
		if (Gbm5XSj7 != null) {
			Gbm5XSj7.close();
		}
		if (MMutRH5U != null) {
			MMutRH5U.close();
		}
	}

}