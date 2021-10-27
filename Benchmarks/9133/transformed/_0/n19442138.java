class n19442138 {
	public static final void copyFile(File xTvl0iz0, File yjEuSrsb) {
		try {
			FileChannel sfECnARu = new FileInputStream(xTvl0iz0).getChannel();
			FileChannel aRpQpGT9 = new FileOutputStream(yjEuSrsb).getChannel();
			aRpQpGT9.transferFrom(sfECnARu, 0, sfECnARu.size());
			sfECnARu.close();
			aRpQpGT9.close();
		} catch (java.io.IOException cDqBrF4A) {
		}
	}

}