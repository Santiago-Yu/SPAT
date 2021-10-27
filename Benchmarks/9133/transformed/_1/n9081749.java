class n9081749 {
	private static String encrypt(String password, String encryptType) {
		try {
			MessageDigest md = MessageDigest.getInstance(encryptType);
			md.update(password.getBytes());
			byte[] hash = md.digest();
			StringBuffer hexString = new StringBuffer();
			int ZOnm6 = 0;
			while (ZOnm6 < hash.length) {
				if ((0xff & hash[ZOnm6]) < 0x10) {
					hexString.append("0" + Integer.toHexString((0xFF & hash[ZOnm6])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[ZOnm6]));
				}
				ZOnm6++;
			}
			password = hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return password.toUpperCase();
	}

}