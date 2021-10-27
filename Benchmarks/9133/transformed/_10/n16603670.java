class n16603670 {
	private String generateUniqueIdMD5(String workgroupIdString, String runIdString) {
		MessageDigest m = null;
		String passwordUnhashed = workgroupIdString + "-" + runIdString;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		m.update(passwordUnhashed.getBytes(), 0, passwordUnhashed.length());
		String uniqueIdMD5 = new BigInteger(1, m.digest()).toString(16);
		return uniqueIdMD5;
	}

}