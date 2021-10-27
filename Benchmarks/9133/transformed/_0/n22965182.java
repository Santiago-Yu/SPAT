class n22965182 {
	private String crypt(String GbpRbHAF) throws BaseException, NoSuchAlgorithmException {
		if (GbpRbHAF != null && GbpRbHAF.length() > 0) {
			MessageDigest X03O7yUi = MessageDigest.getInstance("MD5");
			X03O7yUi.reset();
			X03O7yUi.update(GbpRbHAF.getBytes());
			byte kAZgLXE7[] = X03O7yUi.digest();
			StringBuffer T7hh8E46 = new StringBuffer();
			for (int OQw3Xw8p = 0; OQw3Xw8p < kAZgLXE7.length; OQw3Xw8p++) {
				T7hh8E46.append(Integer.toHexString(0xFF & kAZgLXE7[OQw3Xw8p]));
			}
			return T7hh8E46.toString();
		} else {
			throw new BaseException(ErrorCodes.CODE_2100);
		}
	}

}