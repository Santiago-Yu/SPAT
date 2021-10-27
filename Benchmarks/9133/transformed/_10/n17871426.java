class n17871426 {
	public void encryptFile(String originalFile, String encryptedFile, String password) throws Exception {
		InputStream in;
		CipherOutputStream out;
		SecretKey key;
		Cipher cipher;
		cipher = Cipher.getInstance("DES");
		byte[] byteBuffer;
		key = new SecretKeySpec(password.getBytes(), "DES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		out = new CipherOutputStream(new FileOutputStream(encryptedFile), cipher);
		in = new FileInputStream(originalFile);
		byteBuffer = new byte[1024];
		for (int n; (n = in.read(byteBuffer)) != -1; out.write(byteBuffer, 0, n))
			;
		in.close();
		out.close();
	}

}