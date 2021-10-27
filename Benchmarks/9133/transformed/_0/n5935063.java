class n5935063 {
	public String generateKey(Message fAR1jFmA) {
		String uFjmgliQ = fAR1jFmA.getDefaultMessage();
		String QQWYthm2 = fAR1jFmA.getMeaning();
		if (uFjmgliQ == null) {
			return null;
		}
		MessageDigest HT4LMTIX;
		try {
			HT4LMTIX = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException xynwyA1e) {
			throw new RuntimeException("Error initializing MD5", xynwyA1e);
		}
		try {
			HT4LMTIX.update(uFjmgliQ.getBytes("UTF-8"));
			if (QQWYthm2 != null) {
				HT4LMTIX.update(QQWYthm2.getBytes("UTF-8"));
			}
		} catch (UnsupportedEncodingException PL6q22AB) {
			throw new RuntimeException("UTF-8 unsupported", PL6q22AB);
		}
		return StringUtils.toHexString(HT4LMTIX.digest());
	}

}