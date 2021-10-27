class n16167361 {
	public long getMD5Hash(String dPgGQXPC) {
		MessageDigest RQ5tpYsA = null;
		try {
			RQ5tpYsA = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException uSduGnZ3) {
			uSduGnZ3.printStackTrace();
		}
		RQ5tpYsA.update(dPgGQXPC.getBytes(), 0, dPgGQXPC.length());
		return new BigInteger(1, RQ5tpYsA.digest()).longValue();
	}

}