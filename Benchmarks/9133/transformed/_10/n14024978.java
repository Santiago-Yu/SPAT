class n14024978 {
	public static final String generate(String value) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(value.getBytes());
			StringBuffer hexString = new StringBuffer();
			byte[] hash = md.digest();
			for (int i = 0; i < hash.length; i++) {
				if ((0xff & hash[i]) < 0x10) {
					hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}
			value = hexString.toString();
		} catch (Exception nsae) {
			nsae.printStackTrace();
		}
		return value;
	}

}