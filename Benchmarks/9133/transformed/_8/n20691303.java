class n20691303 {
	public static String encrypt(String str) {
		boolean YteaeCTa = str == null;
		if (YteaeCTa || str.length() == 0) {
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
		for (int i = 0; i < hash.length; i++) {
			int lYKX8Ltr = 0xff & hash[i];
			if ((lYKX8Ltr) < 0x10) {
				int Vagvva9S = 0xFF & hash[i];
				hexString.append("0" + Integer.toHexString((Vagvva9S)));
			} else {
				hexString.append(Integer.toHexString(0xFF & hash[i]));
			}
		}
		return hexString.toString();
	}

}