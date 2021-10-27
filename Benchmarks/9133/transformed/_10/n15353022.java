class n15353022 {
	private String calculateHash(String s) {
		MessageDigest messageDigest;
		if (s == null) {
			return null;
		}
		try {
			messageDigest = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			logger.error("Could not find a message digest algorithm.");
			return null;
		}
		messageDigest.update(s.getBytes());
		StringBuilder sb = new StringBuilder();
		byte[] hash = messageDigest.digest();
		for (byte b : hash) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}

}