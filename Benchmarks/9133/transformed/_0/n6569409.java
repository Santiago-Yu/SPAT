class n6569409 {
	public String obfuscateString(String OwjbYvfY) {
		String GcoCs5tg = null;
		try {
			MessageDigest zUmKLZ10 = MessageDigest.getInstance(ENCRYPTION_ALGORITHM);
			zUmKLZ10.update(OwjbYvfY.getBytes());
			byte[] fYp7ZAQi = zUmKLZ10.digest();
			GcoCs5tg = new String(Base64.encode(fYp7ZAQi)).replace(DELIM_PATH, '=');
		} catch (NoSuchAlgorithmException xMAn5xVN) {
			StatusHandler.log("SHA not available", null);
			GcoCs5tg = LABEL_FAILED_TO_OBFUSCATE;
		}
		return GcoCs5tg;
	}

}