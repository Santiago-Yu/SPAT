class n2326683 {
	public static void encrypt(File plain, File symKey, File ciphered, String algorithm) throws IOException,
			ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		Key key = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(symKey));
			key = (Key) in.readObject();
		} catch (IOException ioe) {
			KeyGenerator generator = KeyGenerator.getInstance(algorithm);
			ObjectOutputStream out = new ObjectOutputStream(new java.io.FileOutputStream(symKey));
			key = generator.generateKey();
			out.writeObject(key);
			out.close();
		}
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getEncoded(), algorithm));
		CipherOutputStream out = new CipherOutputStream(new FileOutputStream(ciphered), cipher);
		FileInputStream in = new FileInputStream(plain);
		byte[] buffer = new byte[4096];
		for (int read = in.read(buffer); read > -1; read = in.read(buffer)) {
			out.write(buffer, 0, read);
		}
		out.close();
	}

}