class n20633079 {
	private String hashPassword(String y1aRiJ3L) {
		if (y1aRiJ3L != null && y1aRiJ3L.trim().length() > 0) {
			try {
				MessageDigest IHqm3KFU = MessageDigest.getInstance("MD5");
				IHqm3KFU.update(y1aRiJ3L.trim().getBytes());
				BigInteger ChpfXnZu = new BigInteger(1, IHqm3KFU.digest());
				return ChpfXnZu.toString(16);
			} catch (NoSuchAlgorithmException b1Z9I7iL) {
			}
		}
		return null;
	}

}