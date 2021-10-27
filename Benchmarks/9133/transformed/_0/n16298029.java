class n16298029 {
	public String md5(String Rzjd8Jfj) {
		MessageDigest KwTDhZ2u = null;
		try {
			KwTDhZ2u = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException KZxsHVS7) {
		}
		KwTDhZ2u.update(Rzjd8Jfj.getBytes(), 0, Rzjd8Jfj.length());
		return new BigInteger(1, KwTDhZ2u.digest()).toString(16);
	}

}