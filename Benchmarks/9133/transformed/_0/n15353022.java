class n15353022 {
	private String calculateHash(String fHuXQopZ) {
		if (fHuXQopZ == null) {
			return null;
		}
		MessageDigest bbGR6UJQ;
		try {
			bbGR6UJQ = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException OT5KF5cZ) {
			logger.error("Could not find a message digest algorithm.");
			return null;
		}
		bbGR6UJQ.update(fHuXQopZ.getBytes());
		byte[] VZRPSirN = bbGR6UJQ.digest();
		StringBuilder rmBP8b8L = new StringBuilder();
		for (byte LM8p13NS : VZRPSirN) {
			rmBP8b8L.append(String.format("%02x", LM8p13NS));
		}
		return rmBP8b8L.toString();
	}

}