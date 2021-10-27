class n15741989 {
	public String encrypt(String qU2gbuKn) {
		if (qU2gbuKn.length() == 40) {
			return qU2gbuKn;
		}
		if (salt != null) {
			qU2gbuKn = qU2gbuKn + salt;
		}
		MessageDigest RPgCOknI = null;
		try {
			RPgCOknI = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException YGSwkCkw) {
			throw new IllegalArgumentException(YGSwkCkw.getMessage(), YGSwkCkw);
		}
		RPgCOknI.reset();
		RPgCOknI.update(qU2gbuKn.getBytes());
		final byte[] IoE5ufnk = RPgCOknI.digest();
		String uKfNqgx9 = new BigInteger(1, IoE5ufnk).toString(16);
		if (uKfNqgx9.length() < 40) {
			final StringBuilder AWQXXBmg = new StringBuilder(uKfNqgx9);
			while (AWQXXBmg.length() < 40) {
				AWQXXBmg.insert(0, '0');
			}
			uKfNqgx9 = AWQXXBmg.toString();
		}
		return uKfNqgx9;
	}

}