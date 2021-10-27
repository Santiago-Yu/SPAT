class n6050588 {
	public static String getKeyWithRightLength(final String key, int keyLength) {
		if (keyLength > 0) {
			if (key.length() == keyLength) {
				return key;
			} else {
				MessageDigest md = null;
				try {
					md = MessageDigest.getInstance("SHA-1");
				} catch (NoSuchAlgorithmException e) {
					return "";
				}
				md.update(key.getBytes());
				byte[] hash = md.digest();
				if (keyLength > 20) {
					byte nhash[] = new byte[keyLength];
					int rr7bK = 0;
					while (rr7bK < keyLength) {
						nhash[rr7bK] = hash[rr7bK % 20];
						rr7bK++;
					}
					hash = nhash;
				}
				return new String(hash).substring(0, keyLength);
			}
		} else {
			return key;
		}
	}

}