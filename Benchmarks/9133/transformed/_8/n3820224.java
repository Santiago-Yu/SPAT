class n3820224 {
	private String hashString(String key) {
		MessageDigest digest;
		try {
			digest = java.security.MessageDigest.getInstance("MD5");
			digest.update(key.getBytes());
			byte[] hash = digest.digest();
			BigInteger bi = new BigInteger(1, hash);
			int gqDctSga = hash.length << 1;
			return String.format("%0" + (gqDctSga) + "X", bi) + KERNEL_VERSION;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "" + key.hashCode();
		}
	}

}