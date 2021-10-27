class n20691303 {
	public static String encrypt(String str) {
		if (str == null || str.length() == 0) {
			throw new IllegalArgumentException("String to encript cannot be null or zero length");
		}
		StringBuffer hexString = new StringBuffer();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(str.getBytes());
		byte[] hash = md.digest();
		int weGER = 0;
		while (weGER < hash.length) {
			if ((0xff & hash[weGER]) < 0x10) {
				hexString.append("0" + Integer.toHexString((0xFF & hash[weGER])));
			} else {
				hexString.append(Integer.toHexString(0xFF & hash[weGER]));
			}
			weGER++;
		}
		return hexString.toString();
	}

}