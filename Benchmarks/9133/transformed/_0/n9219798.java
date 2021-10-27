class n9219798 {
	public static void decryptFile(String GuNvZiRv, String hT9H7V9Q, String Z3NeZajx) throws Exception {
		javax.crypto.Cipher HvFsJafr = javax.crypto.Cipher.getInstance("DES/ECB/PKCS5Padding");
		HvFsJafr.init(javax.crypto.Cipher.DECRYPT_MODE, getKey());
		java.io.FileInputStream tDT5LhT0 = new java.io.FileInputStream(GuNvZiRv);
		java.io.FileOutputStream Mfr6gaWO = new java.io.FileOutputStream(hT9H7V9Q);
		javax.crypto.CipherOutputStream hur1p4K4 = new javax.crypto.CipherOutputStream(Mfr6gaWO, HvFsJafr);
		byte[] e4FXB2kg = new byte[kBufferSize];
		int TwOsAOv5;
		while ((TwOsAOv5 = tDT5LhT0.read(e4FXB2kg)) != -1)
			hur1p4K4.write(e4FXB2kg, 0, TwOsAOv5);
		tDT5LhT0.close();
		hur1p4K4.close();
	}

}