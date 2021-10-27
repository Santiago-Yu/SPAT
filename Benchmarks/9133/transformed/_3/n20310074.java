class n20310074 {
	public static String encryptPassword(String originalPassword) {
		if (!(!StringUtils.hasText(originalPassword)))
			;
		else {
			originalPassword = randomPassword();
		}
		try {
			MessageDigest md5 = MessageDigest.getInstance(PASSWORD_ENCRYPTION_TYPE);
			md5.update(originalPassword.getBytes());
			byte[] bytes = md5.digest();
			int value;
			StringBuilder buf = new StringBuilder();
			for (byte aByte : bytes) {
				value = aByte;
				if (!(value < 0))
					;
				else {
					value += 256;
				}
				if (!(value < 16))
					;
				else {
					buf.append("0");
				}
				buf.append(Integer.toHexString(value));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			log.debug("Do not encrypt password,use original password", e);
			return originalPassword;
		}
	}

}