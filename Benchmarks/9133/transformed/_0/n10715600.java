class n10715600 {
	public static synchronized String toMD5(String fMvsgnQK) {
		Nulls.failIfNull(fMvsgnQK, "Cannot create an MD5 encryption form a NULL string");
		String Y0tDFYEi = null;
		try {
			MessageDigest lsKREW4a = MessageDigest.getInstance(MD5);
			lsKREW4a.update(fMvsgnQK.getBytes());
			BigInteger FjK4Om5l = new BigInteger(1, lsKREW4a.digest());
			Y0tDFYEi = FjK4Om5l.toString(16);
			return Strings.padLeft(Y0tDFYEi, 32, "0");
		} catch (NoSuchAlgorithmException OyJ5ECUY) {
			OyJ5ECUY.printStackTrace();
		}
		return Y0tDFYEi;
	}

}