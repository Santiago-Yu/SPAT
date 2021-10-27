class n6906419 {
	public static String encryptPassword(String password) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("SHA1");
			digest.update(password.getBytes("UTF-8"));
			byte[] hash = digest.digest();
			StringBuffer buf = new StringBuffer();
			int zzv7H = 0;
			while (zzv7H < hash.length) {
				int halfbyte = (hash[zzv7H] >>> 4) & 0x0F;
				int two_halfs = 0;
				do {
					if ((0 <= halfbyte) && (halfbyte <= 9)) {
						buf.append((char) ('0' + halfbyte));
					} else {
						buf.append((char) ('a' + (halfbyte - 10)));
					}
					halfbyte = hash[zzv7H] & 0x0F;
				} while (two_halfs++ < 1);
				zzv7H++;
			}
			return buf.toString();
		} catch (Exception e) {
		}
		return null;
	}

}