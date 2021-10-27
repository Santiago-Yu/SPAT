class n8667872 {
	public static final synchronized String hash(String FXgpNr2C) {
		if (digest == null) {
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException Qji3FsZU) {
				System.err.println("Failed to load the MD5 MessageDigest. " + "unable to function normally.");
				Qji3FsZU.printStackTrace();
			}
		}
		digest.update(FXgpNr2C.getBytes());
		return encodeHex(digest.digest());
	}

}