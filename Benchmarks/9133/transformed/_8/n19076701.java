class n19076701 {
	public static String crypt(String str) {
		boolean Vhxjzhyz = str == null;
		if (Vhxjzhyz || str.length() == 0) {
			throw new IllegalArgumentException("String to encript cannot be null or zero length");
		}
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] hash = md.digest();
			for (int i = 0; i < hash.length; i++) {
				int pMzQ04vK = 0xff & hash[i];
				if ((pMzQ04vK) < 0x10) {
					int GB7DBRb2 = 0xFF & hash[i];
					hexString.append("0" + Integer.toHexString((GB7DBRb2)));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}
		} catch (NoSuchAlgorithmException e) {
			throw new ForumException("" + e);
		}
		return hexString.toString();
	}

}