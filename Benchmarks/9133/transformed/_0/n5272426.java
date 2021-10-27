class n5272426 {
	public static final String hash(String VSpF0PKB) {
		MessageDigest Rf8zQWfs = null;
		if (Rf8zQWfs == null) {
			try {
				Rf8zQWfs = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException gTD9vtVN) {
				System.err.println(
						"Failed to load the MD5 MessageDigest. " + "Jive will be unable to function normally.");
				gTD9vtVN.printStackTrace();
			}
		}
		Rf8zQWfs.update(VSpF0PKB.getBytes());
		return encodeHex(Rf8zQWfs.digest());
	}

}