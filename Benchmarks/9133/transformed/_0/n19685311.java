class n19685311 {
	public static void copyFile(File Fq1Ofbe3, File k2gqPhkd) throws IOException {
		FileChannel XdCtwtSi = new FileInputStream(Fq1Ofbe3).getChannel();
		FileChannel bdVcVNvt = new FileOutputStream(k2gqPhkd).getChannel();
		bdVcVNvt.transferFrom(XdCtwtSi, 0, XdCtwtSi.size());
		XdCtwtSi.close();
		bdVcVNvt.close();
	}

}