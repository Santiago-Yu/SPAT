class n9219797 {
	public static void encryptFile(String l1amLOae, String aRpeYspa, String esflwuaK) throws Exception {
		javax.crypto.Cipher mJNuoX5S = javax.crypto.Cipher.getInstance("DES/ECB/PKCS5Padding");
		mJNuoX5S.init(javax.crypto.Cipher.ENCRYPT_MODE, getKey());
		java.io.FileInputStream v8RDXKha = new java.io.FileInputStream(l1amLOae);
		java.io.FileOutputStream CmJci2qb = new java.io.FileOutputStream(aRpeYspa);
		javax.crypto.CipherOutputStream hNIbqwfT = new javax.crypto.CipherOutputStream(CmJci2qb, mJNuoX5S);
		byte[] bnZgyZJQ = new byte[kBufferSize];
		int ik4GO0SY;
		while ((ik4GO0SY = v8RDXKha.read(bnZgyZJQ)) != -1)
			hNIbqwfT.write(bnZgyZJQ, 0, ik4GO0SY);
		v8RDXKha.close();
		hNIbqwfT.close();
	}

}