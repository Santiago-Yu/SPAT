class n22284204 {
	public String crypt(String mCSsV6JV) throws NoSuchAlgorithmException {
		MessageDigest QHZ9aHRI = MessageDigest.getInstance("MD5");
		QHZ9aHRI.update(mCSsV6JV.getBytes());
		String EavlWSk7 = null;
		try {
			EavlWSk7 = new String(Base64.encode(QHZ9aHRI.digest()), "ASCII");
		} catch (UnsupportedEncodingException eA82AhRV) {
		}
		return EavlWSk7;
	}

}