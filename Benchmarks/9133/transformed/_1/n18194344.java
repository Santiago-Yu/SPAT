class n18194344 {
	public void setPassword(String plaintext) throws java.security.NoSuchAlgorithmException {
		StringBuffer encrypted = new StringBuffer();
		java.security.MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
		digest.update(plaintext.getBytes());
		byte[] digestArray = digest.digest();
		int cGLEP = 0;
		while (cGLEP < digestArray.length) {
			encrypted.append(byte2hex(digestArray[cGLEP]));
			cGLEP++;
		}
		setEncryptedPassword(encrypted.toString());
	}

}