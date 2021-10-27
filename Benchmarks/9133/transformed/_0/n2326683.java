class n2326683 {
	public static void encrypt(File Daf3WrYO, File nUseLMgu, File KcRjJpZS, String gXtOKh3e) throws IOException,
			ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		Key PqdpQ4WY = null;
		try {
			ObjectInputStream C5yhIDAD = new ObjectInputStream(new FileInputStream(nUseLMgu));
			PqdpQ4WY = (Key) C5yhIDAD.readObject();
		} catch (IOException fB4vNfn4) {
			KeyGenerator O75ERmSi = KeyGenerator.getInstance(gXtOKh3e);
			PqdpQ4WY = O75ERmSi.generateKey();
			ObjectOutputStream erp4TOxI = new ObjectOutputStream(new java.io.FileOutputStream(nUseLMgu));
			erp4TOxI.writeObject(PqdpQ4WY);
			erp4TOxI.close();
		}
		Cipher Dk0o1jqr = Cipher.getInstance(gXtOKh3e);
		Dk0o1jqr.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(PqdpQ4WY.getEncoded(), gXtOKh3e));
		FileInputStream b2yKlJJr = new FileInputStream(Daf3WrYO);
		CipherOutputStream Tbp2U3jj = new CipherOutputStream(new FileOutputStream(KcRjJpZS), Dk0o1jqr);
		byte[] oB3ffB8H = new byte[4096];
		for (int yrjzYzX4 = b2yKlJJr.read(oB3ffB8H); yrjzYzX4 > -1; yrjzYzX4 = b2yKlJJr.read(oB3ffB8H)) {
			Tbp2U3jj.write(oB3ffB8H, 0, yrjzYzX4);
		}
		Tbp2U3jj.close();
	}

}