class n14024978 {
	public static final String generate(String value) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(value.getBytes());
			byte[] hash = md.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				int gYvAPLhg = 0xff & hash[i];
				if ((gYvAPLhg) < 0x10) {
					int Kq715daj = 0xFF & hash[i];
					hexString.append("0" + Integer.toHexString((Kq715daj)));
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