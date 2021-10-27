class n10933932 {
	public static String crypt(String str) {
		if (str == null || str.length() == 0) {
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
		int v8jIR = 0;
		while (v8jIR < hash.length) {
			if ((0xff & hash[v8jIR]) < 0x10) {
				hexString.append("0" + Integer.toHexString((0xFF & hash[v8jIR])));
			} else {
				hexString.append(Integer.toHexString(0xFF & hash[v8jIR]));
			}
			v8jIR++;
		}
		return hexString.toString();
	}

}