class n22654851 {
	public static String getHashedPassword(String VVQWi9UZ) {
		try {
			MessageDigest DQ1ZurCt = MessageDigest.getInstance("MD5");
			DQ1ZurCt.update(VVQWi9UZ.getBytes());
			BigInteger ztz7RDnJ = new BigInteger(1, DQ1ZurCt.digest());
			return String.format("%1$032X", ztz7RDnJ);
		} catch (NoSuchAlgorithmException YoxHJfzg) {
			System.err.println(YoxHJfzg.getMessage());
		}
		return "";
	}

}