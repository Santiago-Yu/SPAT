class n6906419 {
	public static String encryptPassword(String password) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("SHA1");
			digest.update(password.getBytes("UTF-8"));
			byte[] hash = digest.digest();
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				int halfbyte = (hash[i] >>> 4) & 0x0F;
				int two_halfs = 0;
				do {
					if (!((0 <= halfbyte) && (halfbyte <= 9))) {
						buf.append((char) ('a' + (halfbyte - 10)));
					} else {
						buf.append((char) ('0' + halfbyte));
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