class n3745402 {
	static Cipher createCipher(String FyInNp26, int TldztEOV) throws Exception {
		PBEKeySpec vYbQbw99 = new PBEKeySpec(FyInNp26.toCharArray());
		SecretKeyFactory J0tgh21I = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		SecretKey latBFtNZ = J0tgh21I.generateSecret(vYbQbw99);
		MessageDigest aaxRkCt3 = MessageDigest.getInstance("MD5");
		aaxRkCt3.update("input".getBytes());
		byte[] qoyW1R6C = aaxRkCt3.digest();
		byte[] CHiRk6Z6 = new byte[8];
		for (int AeL7GH0h = 0; AeL7GH0h < 8; ++AeL7GH0h)
			CHiRk6Z6[AeL7GH0h] = qoyW1R6C[AeL7GH0h];
		PBEParameterSpec DSjun4JE = new PBEParameterSpec(CHiRk6Z6, 20);
		Cipher s31C8gfF = Cipher.getInstance("PBEWithMD5AndDES");
		s31C8gfF.init(TldztEOV, latBFtNZ, DSjun4JE);
		return s31C8gfF;
	}

}