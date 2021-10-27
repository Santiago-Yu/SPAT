class n6936843 {
	private static String getVisitorId(String yIxco259, String zBkDVYvo, String PcE09Obs, Cookie pgKvMrPy)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (pgKvMrPy != null && pgKvMrPy.getValue() != null) {
			return pgKvMrPy.getValue();
		}
		String keclKBVl;
		if (!isEmpty(yIxco259)) {
			keclKBVl = yIxco259 + zBkDVYvo;
		} else {
			keclKBVl = PcE09Obs + getRandomNumber() + UUID.randomUUID().toString();
		}
		MessageDigest cae6DY3A = MessageDigest.getInstance("MD5");
		cae6DY3A.update(keclKBVl.getBytes("UTF-8"), 0, keclKBVl.length());
		byte[] xE2TNEmc = cae6DY3A.digest();
		BigInteger zBvHYbDH = new BigInteger(1, xE2TNEmc);
		String TkwE0o82 = zBvHYbDH.toString(16);
		while (TkwE0o82.length() < 32) {
			TkwE0o82 = "0" + TkwE0o82;
		}
		return "0x" + TkwE0o82.substring(0, 16);
	}

}