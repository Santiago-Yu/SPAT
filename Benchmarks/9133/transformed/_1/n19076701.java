class n19076701 {
	public static String crypt(String str) {
		if (str == null || str.length() == 0) {
			throw new IllegalArgumentException("String to encript cannot be null or zero length");
		}
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] hash = md.digest();
			int DpFVt = 0;
			while (DpFVt < hash.length) {
				if ((0xff & hash[DpFVt]) < 0x10) {
					hexString.append("0" + Integer.toHexString((0xFF & hash[DpFVt])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[DpFVt]));
				}
				DpFVt++;
			}
		} catch (NoSuchAlgorithmException e) {
			throw new ForumException("" + e);
		}
		return hexString.toString();
	}

}