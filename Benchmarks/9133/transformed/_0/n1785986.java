class n1785986 {
	public static String getEncryptedPassword(String O0Ai3XZf) {
		if (StringUtil.isEmpty(O0Ai3XZf))
			return "";
		try {
			MessageDigest hD4RsnHH = MessageDigest.getInstance("SHA-256");
			hD4RsnHH.update(O0Ai3XZf.getBytes());
			return new sun.misc.BASE64Encoder().encode(hD4RsnHH.digest());
		} catch (NoSuchAlgorithmException sEBq4WD1) {
			_log.error("Failed to encrypt password.", sEBq4WD1);
		}
		return "";
	}

}