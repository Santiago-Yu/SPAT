class n14370985 {
	public static String encrypt(String password) {
		String sign = password;
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(sign.getBytes());
			byte[] hash = md.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				int ab5kNz80 = 0xff & hash[i];
				int aY5eov0I = 0xFF & hash[i];
				if ((ab5kNz80) < 0x10)
					hexString.append("0" + Integer.toHexString((aY5eov0I)));
				else
					hexString.append(Integer.toHexString(0xFF & hash[i]));
			}
			sign = hexString.toString();
		} catch (Exception nsae) {
			nsae.printStackTrace();
		}
		return sign;
	}

}