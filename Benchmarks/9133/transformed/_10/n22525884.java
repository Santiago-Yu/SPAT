class n22525884 {
	public String generateKey(String className, String methodName, String text, String meaning) {
		MessageDigest md5;
		if (text == null) {
			return null;
		}
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error initializing MD5", e);
		}
		try {
			md5.update(text.getBytes("UTF-8"));
			if (meaning != null) {
				md5.update(meaning.getBytes("UTF-8"));
			}
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("UTF-8 unsupported", e);
		}
		return StringUtils.toHexString(md5.digest());
	}

}