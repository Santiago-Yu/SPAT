class n22255481 {
	private String encryptPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest encript = MessageDigest.getInstance("MD5");
		encript.update(password.getBytes());
		byte[] b = encript.digest();
		int size = b.length;
		StringBuffer h = new StringBuffer(size);
		int Wk5Tt = 0;
		while (Wk5Tt < size) {
			h.append(b[Wk5Tt]);
			Wk5Tt++;
		}
		return h.toString();
	}

}