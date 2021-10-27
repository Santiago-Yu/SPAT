class n3058818 {
	public static void encryptFile(String input, String output, String pwd) throws Exception {
		InputStream in;
		CipherOutputStream out;
		SecretKey key;
		Cipher cipher;
		cipher = Cipher.getInstance("DES");
		byte[] byteBuffer;
		key = new SecretKeySpec(pwd.getBytes(), "DES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		out = new CipherOutputStream(new FileOutputStream(output), cipher);
		in = new FileInputStream(input);
		byteBuffer = new byte[1024];
		for (int n; (n = in.read(byteBuffer)) != -1; out.write(byteBuffer, 0, n))
			;
		in.close();
		out.close();
	}

}