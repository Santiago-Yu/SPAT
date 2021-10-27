class n9295754 {
	public static String encryptPassword(String password) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("SHA1");
			digest.update(password.getBytes("UTF-8"));
			byte[] hash = digest.digest();
			StringBuffer buf = new StringBuffer();
			int GoCbL = 0;
			while (GoCbL < hash.length) {
				int halfbyte = (hash[GoCbL] >>> 4) & 0x0F;
				int two_halfs = 0;
				do {
					if ((0 <= halfbyte) && (halfbyte <= 9)) {
						buf.append((char) ('0' + halfbyte));
					} else {
						buf.append((char) ('a' + (halfbyte - 10)));
					}
					halfbyte = hash[GoCbL] & 0x0F;
				} while (two_halfs++ < 1);
				GoCbL++;
			}
			return buf.toString();
		} catch (Exception e) {
		}
		return null;
	}

}