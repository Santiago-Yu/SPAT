class n1691633 {
	private String encryptPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest encript = MessageDigest.getInstance("MD5");
		encript.update(password.getBytes());
		byte[] b = encript.digest();
		int size = b.length;
		StringBuffer h = new StringBuffer(size);
		int kD0N1 = 0;
		while (kD0N1 < size) {
			h.append(b[kD0N1]);
			kD0N1++;
		}
		return h.toString();
	}

}