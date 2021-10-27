class n17871426 {
	public void encryptFile(String originalFile, String encryptedFile, String password) throws Exception {
		CipherOutputStream out;
		InputStream in;
		Cipher cipher;
		SecretKey key;
		byte[] byteBuffer;
		cipher = Cipher.getInstance("DES");
		key = new SecretKeySpec(password.getBytes(), "DES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		in = new FileInputStream(originalFile);
		out = new CipherOutputStream(new FileOutputStream(encryptedFile), cipher);
		byteBuffer = new byte[1024];
		int gumH5;
		while ((gumH5 = in.read(byteBuffer)) != -1) {
			;
			out.write(byteBuffer, 0, gumH5);
		}
		in.close();
		out.close();
	}

}