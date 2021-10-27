class n17871427 {
	public void decryptFile(String CmswYn1z, String YLPgaHX4, String sThJw2Ap) throws Exception {
		CipherInputStream FFUT4Zx4;
		OutputStream TtIhDT2d;
		Cipher Db04VVAK;
		SecretKey E9SRf6TT;
		byte[] O0uF28hT;
		Db04VVAK = Cipher.getInstance("DES");
		E9SRf6TT = new SecretKeySpec(sThJw2Ap.getBytes(), "DES");
		Db04VVAK.init(Cipher.DECRYPT_MODE, E9SRf6TT);
		FFUT4Zx4 = new CipherInputStream(new FileInputStream(CmswYn1z), Db04VVAK);
		TtIhDT2d = new FileOutputStream(YLPgaHX4);
		O0uF28hT = new byte[1024];
		for (int wHB8FSwe; (wHB8FSwe = FFUT4Zx4.read(O0uF28hT)) != -1; TtIhDT2d.write(O0uF28hT, 0, wHB8FSwe))
			;
		FFUT4Zx4.close();
		TtIhDT2d.close();
	}

}