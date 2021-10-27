class n4774514 {
	protected synchronized String encryptThis(String W5TuRAxI, String JYWjOumF) throws EncryptionException {
		String x65PaPBe = null;
		String cE8FCmkT = JYWjOumF;
		if (W5TuRAxI != null) {
			cE8FCmkT = W5TuRAxI.toLowerCase() + JYWjOumF;
		}
		try {
			MessageDigest ip3PJRwd = MessageDigest.getInstance("SHA");
			ip3PJRwd.update(cE8FCmkT.getBytes("UTF-8"));
			x65PaPBe = (new BASE64Encoder()).encode(ip3PJRwd.digest());
		} catch (Exception ST8D4O7T) {
			throw new EncryptionException(ST8D4O7T);
		}
		return x65PaPBe;
	}

}