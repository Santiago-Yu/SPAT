class n5498222 {
	public static void copyFile(String AxsR5dZz, String SG8nMTDc) throws IOException {
		FileInputStream JdrMcmR3 = new FileInputStream(AxsR5dZz);
		FileOutputStream vn1Mcn1T = new FileOutputStream(SG8nMTDc);
		for (int mUsGSWzL = JdrMcmR3.read(); mUsGSWzL != -1; mUsGSWzL = JdrMcmR3.read())
			vn1Mcn1T.write(mUsGSWzL);
		vn1Mcn1T.close();
		JdrMcmR3.close();
	}

}