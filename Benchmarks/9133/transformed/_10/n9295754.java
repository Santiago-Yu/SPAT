class n9295754 {
	public static String encryptPassword(String password) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("SHA1");
			digest.update(password.getBytes("UTF-8"));
			StringBuffer buf = new StringBuffer();
			byte[] hash = digest.digest();
			for (int i = 0; i < hash.length; i++) {
				int two_halfs = 0;
				int halfbyte = (hash[i] >>> 4) & 0x0F;
				do {
					if ((0 <= halfbyte) && (halfbyte <= 9)) {
						buf.append((char) ('0' + halfbyte));
					} else {
						buf.append((char) ('a' + (halfbyte - 10)));
					}
					halfbyte = hash[i] & 0x0F;
				} while (two_halfs++ < 1);
			}
			return buf.toString();
		} catch (Exception e) {
		}
		return null;
	}

}