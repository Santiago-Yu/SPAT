class n17871426 {
	public void encryptFile(String aCvsLUtP, String Q01p1wX3, String LtNwNXcu) throws Exception {
		CipherOutputStream PXNZIlVv;
		InputStream tDT567dl;
		Cipher gEJWJWOZ;
		SecretKey x4y3zXKP;
		byte[] YxO5i9MB;
		gEJWJWOZ = Cipher.getInstance("DES");
		x4y3zXKP = new SecretKeySpec(LtNwNXcu.getBytes(), "DES");
		gEJWJWOZ.init(Cipher.ENCRYPT_MODE, x4y3zXKP);
		tDT567dl = new FileInputStream(aCvsLUtP);
		PXNZIlVv = new CipherOutputStream(new FileOutputStream(Q01p1wX3), gEJWJWOZ);
		YxO5i9MB = new byte[1024];
		for (int fapePEql; (fapePEql = tDT567dl.read(YxO5i9MB)) != -1; PXNZIlVv.write(YxO5i9MB, 0, fapePEql))
			;
		tDT567dl.close();
		PXNZIlVv.close();
	}

}