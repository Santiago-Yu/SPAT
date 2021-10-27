class n10656323 {
	public void copy(File U3lAFxSd, File ZbuAUgoR) throws IOException {
		FileChannel tVlzBzZr = (new FileInputStream(U3lAFxSd)).getChannel();
		FileChannel j8MEwnZh = (new FileOutputStream(ZbuAUgoR)).getChannel();
		tVlzBzZr.transferTo(0, U3lAFxSd.length(), j8MEwnZh);
		tVlzBzZr.close();
		j8MEwnZh.close();
	}

}