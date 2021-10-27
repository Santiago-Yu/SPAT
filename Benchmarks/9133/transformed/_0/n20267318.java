class n20267318 {
	public String getHash(String CiLFmkGH) {
		try {
			MessageDigest MokUkwJz = MessageDigest.getInstance("MD5");
			MokUkwJz.update(CiLFmkGH.getBytes());
			byte[] KjFHFEyN = MokUkwJz.digest();
			return Keystore.hexEncode(KjFHFEyN);
		} catch (Exception SyJbN5GJ) {
			logger.error("Error in creating DN hash: " + SyJbN5GJ.getMessage());
			return null;
		}
	}

}