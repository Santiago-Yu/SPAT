class n539195 {
	static void copy(String bMVm1QBJ, String FBMzKdoy) throws IOException {
		File dTvRfsgw = new File(bMVm1QBJ);
		File t30rziOF = new File(FBMzKdoy);
		if (dTvRfsgw.exists() == false) {
			throw new IOException("file '" + bMVm1QBJ + "' does not exist");
		}
		FileInputStream MStxe2W4 = new FileInputStream(dTvRfsgw);
		FileOutputStream GBcXHz5y = new FileOutputStream(t30rziOF);
		byte[] xwifV5mU = new byte[1024];
		while (MStxe2W4.read(xwifV5mU) > 0)
			GBcXHz5y.write(xwifV5mU);
		MStxe2W4.close();
		GBcXHz5y.close();
	}

}