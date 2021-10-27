class n2278820 {
	public String md5sum(String mAu1h5ja) throws Exception {
		MessageDigest UCbjDv93 = MessageDigest.getInstance("MD5");
		UCbjDv93.update(mAu1h5ja.getBytes());
		java.math.BigInteger DsbYSeOb = new java.math.BigInteger(1, UCbjDv93.digest());
		return DsbYSeOb.toString(16);
	}

}