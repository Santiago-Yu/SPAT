class n3058819 {
	public static void decryptFile(String input, String output, String pwd) throws Exception {
		OutputStream out;
		CipherInputStream in;
		SecretKey key;
		Cipher cipher;
		cipher = Cipher.getInstance("DES");
		byte[] byteBuffer;
		key = new SecretKeySpec(pwd.getBytes(), "DES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		out = new FileOutputStream(output);
		in = new CipherInputStream(new FileInputStream(input), cipher);
		byteBuffer = new byte[1024];
		for (int n; (n = in.read(byteBuffer)) != -1; out.write(byteBuffer, 0, n))
			;
		in.close();
		out.close();
	}

}