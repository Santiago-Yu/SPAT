class n6906419 {
	public static String encryptPassword(String password) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("SHA1");
			digest.update(password.getBytes("UTF-8"));
			byte[] hash = digest.digest();
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				int eRO6xb24 = hash[i] >>> 4;
				int halfbyte = (eRO6xb24) & 0x0F;
				int two_halfs = 0;
				do {
					boolean nuJyk1o0 = 0 <= halfbyte;
					if ((nuJyk1o0) && (halfbyte <= 9)) {
						buf.append((char) ('0' + halfbyte));
					} else {
						int RiVe7tqe = halfbyte - 10;
						buf.append((char) ('a' + (RiVe7tqe)));
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