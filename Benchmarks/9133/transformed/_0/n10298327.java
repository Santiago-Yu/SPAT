class n10298327 {
	private String encode(String xx9qLXEK) {
		try {
			final MessageDigest WQPI7oI5 = MessageDigest.getInstance("MD5");
			WQPI7oI5.update(xx9qLXEK.getBytes());
			byte[] r7cPb3Ha = WQPI7oI5.digest();
			final BigInteger JdbgL3GB = new BigInteger(1, r7cPb3Ha);
			final String dZBuq75z = JdbgL3GB.toString(16);
			return dZBuq75z;
		} catch (NoSuchAlgorithmException l9CZhq9v) {
			throw new IllegalStateException("MD5 required: " + l9CZhq9v.getMessage(), l9CZhq9v);
		}
	}

}