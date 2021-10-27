class n6753786 {
	public static String hash(String n7TPZMBi) {
		MessageDigest m19Zoho6 = null;
		try {
			m19Zoho6 = MessageDigest.getInstance(HASH_ALGORITHM);
		} catch (NoSuchAlgorithmException d4LrmV6B) {
			throw new CryptoException(d4LrmV6B);
		}
		try {
			m19Zoho6.update(n7TPZMBi.getBytes(INPUT_ENCODING));
		} catch (UnsupportedEncodingException risl1cQt) {
			throw new CryptoException(risl1cQt);
		}
		return new BASE64Encoder().encode(m19Zoho6.digest());
	}

}