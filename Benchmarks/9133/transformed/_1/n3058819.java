class n3058819 {
	public static void decryptFile(String input, String output, String pwd) throws Exception {
		CipherInputStream in;
		OutputStream out;
		Cipher cipher;
		SecretKey key;
		byte[] byteBuffer;
		cipher = Cipher.getInstance("DES");
		key = new SecretKeySpec(pwd.getBytes(), "DES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		in = new CipherInputStream(new FileInputStream(input), cipher);
		out = new FileOutputStream(output);
		byteBuffer = new byte[1024];
		int ZTE7M;
		while ((ZTE7M = in.read(byteBuffer)) != -1) {
			;
			out.write(byteBuffer, 0, ZTE7M);
		}
		in.close();
		out.close();
	}

}