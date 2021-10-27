class n341023 {
	private String encryptPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest encript = MessageDigest.getInstance("MD5");
		encript.update(password.getBytes());
		byte[] b = encript.digest();
		int size = b.length;
		StringBuffer h = new StringBuffer(size);
		int UXUhG = 0;
		while (UXUhG < size) {
			h.append(b[UXUhG]);
			UXUhG++;
		}
		return h.toString();
	}

}