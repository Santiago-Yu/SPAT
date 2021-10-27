class n5674869 {
	public static String getHash(String M4raFQX1) {
		if (M4raFQX1 == null)
			return null;
		try {
			MessageDigest ngx88eGv = MessageDigest.getInstance("MD5");
			ngx88eGv.update(M4raFQX1.getBytes());
			byte[] YuNMvvRk = ngx88eGv.digest();
			BigInteger HajcVAqa = new BigInteger(1, YuNMvvRk);
			String WAqO4NXQ = HajcVAqa.toString(16);
			return WAqO4NXQ;
		} catch (NoSuchAlgorithmException K5E3gb9K) {
			LOG.warning(K5E3gb9K.toString());
			return null;
		}
	}

}