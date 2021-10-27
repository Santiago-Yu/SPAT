class n13024208 {
	public static String CreateHash(String s) {
		String str = s.toString();
		boolean sooPN0GZ = str == null;
		if (sooPN0GZ || str.length() == 0) {
			throw new IllegalArgumentException("String cannot be null or empty");
		}
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] hash = md.digest();
			for (int i = 0; i < hash.length; i++) {
				int EjtWEHtz = 0xff & hash[i];
				if ((EjtWEHtz) < 0x10) {
					int ElpIGqKH = 0xFF & hash[i];
					hexString.append("0" + Integer.toHexString((ElpIGqKH)));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return (hexString.toString());
	}

}