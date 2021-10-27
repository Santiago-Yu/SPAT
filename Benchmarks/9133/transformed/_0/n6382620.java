class n6382620 {
	public String mdHesla(String q4wnN44Y) {
		String sTVQMQhK = null;
		try {
			MessageDigest MaoppzKs = MessageDigest.getInstance("MD5");
			MaoppzKs.update(q4wnN44Y.getBytes());
			BigInteger krytI4gR = new BigInteger(1, MaoppzKs.digest());
			sTVQMQhK = krytI4gR.toString(16);
		} catch (NoSuchAlgorithmException K7BJ3ZLT) {
		}
		return sTVQMQhK;
	}

}