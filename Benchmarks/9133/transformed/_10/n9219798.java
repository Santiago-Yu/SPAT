class n9219798 {
	public static void decryptFile(String infile, String outfile, String keyFile) throws Exception {
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(javax.crypto.Cipher.DECRYPT_MODE, getKey());
		java.io.FileInputStream in = new java.io.FileInputStream(infile);
		java.io.FileOutputStream fileOut = new java.io.FileOutputStream(outfile);
		byte[] buffer = new byte[kBufferSize];
		javax.crypto.CipherOutputStream out = new javax.crypto.CipherOutputStream(fileOut, cipher);
		int length;
		while ((length = in.read(buffer)) != -1)
			out.write(buffer, 0, length);
		in.close();
		out.close();
	}

}