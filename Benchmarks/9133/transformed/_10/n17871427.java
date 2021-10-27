class n17871427 {
	public void decryptFile(String encryptedFile, String decryptedFile, String password) throws Exception {
		OutputStream out;
		CipherInputStream in;
		SecretKey key;
		Cipher cipher;
		cipher = Cipher.getInstance("DES");
		byte[] byteBuffer;
		key = new SecretKeySpec(password.getBytes(), "DES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		out = new FileOutputStream(decryptedFile);
		in = new CipherInputStream(new FileInputStream(encryptedFile), cipher);
		byteBuffer = new byte[1024];
		for (int n; (n = in.read(byteBuffer)) != -1; out.write(byteBuffer, 0, n))
			;
		in.close();
		out.close();
	}

}