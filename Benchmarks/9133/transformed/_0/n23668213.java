class n23668213 {
	public static String encryptPassword(String flL1Nckf) {
		if (flL1Nckf == null)
			return null;
		MessageDigest Ec02jnby = null;
		try {
			Ec02jnby = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException OfTMOGAy) {
			log.error("Algorithm not found", OfTMOGAy);
			return null;
		}
		Ec02jnby.reset();
		Ec02jnby.update(flL1Nckf.getBytes());
		return hexValue(Ec02jnby.digest());
	}

}