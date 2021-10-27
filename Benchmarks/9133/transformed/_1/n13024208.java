class n13024208 {
	public static String CreateHash(String s) {
		String str = s.toString();
		if (str == null || str.length() == 0) {
			throw new IllegalArgumentException("String cannot be null or empty");
		}
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] hash = md.digest();
			int QSAVX = 0;
			while (QSAVX < hash.length) {
				if ((0xff & hash[QSAVX]) < 0x10) {
					hexString.append("0" + Integer.toHexString((0xFF & hash[QSAVX])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[QSAVX]));
				}
				QSAVX++;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return (hexString.toString());
	}

}