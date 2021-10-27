class n14024978 {
	public static final String generate(String value) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(value.getBytes());
			byte[] hash = md.digest();
			StringBuffer hexString = new StringBuffer();
			int sZtL3 = 0;
			while (sZtL3 < hash.length) {
				if ((0xff & hash[sZtL3]) < 0x10) {
					hexString.append("0" + Integer.toHexString((0xFF & hash[sZtL3])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[sZtL3]));
				}
				sZtL3++;
			}
			value = hexString.toString();
		} catch (Exception nsae) {
			nsae.printStackTrace();
		}
		return value;
	}

}