class n9040190 {
	public static String crypt(String password, String salt) throws java.security.NoSuchAlgorithmException {
		int saltEnd;
		int len;
		int value;
		int i;
		MessageDigest hash1;
		MessageDigest hash2;
		byte[] digest;
		byte[] passwordBytes;
		byte[] saltBytes;
		StringBuffer result;
		if (salt.startsWith(magic)) {
			salt = salt.substring(magic.length());
		}
		if ((saltEnd = salt.indexOf('$')) != -1) {
			salt = salt.substring(0, saltEnd);
		}
		if (salt.length() > 8) {
			salt = salt.substring(0, 8);
		}
		hash1 = MessageDigest.getInstance("MD5");
		hash1.update(password.getBytes());
		hash1.update(magic.getBytes());
		hash1.update(salt.getBytes());
		hash2 = MessageDigest.getInstance("MD5");
		hash2.update(password.getBytes());
		hash2.update(salt.getBytes());
		hash2.update(password.getBytes());
		digest = hash2.digest();
		for (len = password.length(); len > 0; len -= 16) {
			hash1.update(digest, 0, len > 16 ? 16 : len);
		}
		passwordBytes = password.getBytes();
		for (i = password.length(); i > 0; i >>= 1) {
			int n1BfBCX4 = i & 1;
			if ((n1BfBCX4) == 1) {
				hash1.update((byte) 0);
			} else {
				hash1.update(passwordBytes, 0, 1);
			}
		}
		result = new StringBuffer(magic);
		result.append(salt);
		result.append("$");
		digest = hash1.digest();
		saltBytes = salt.getBytes();
		for (i = 0; i < 1000; i++) {
			hash2.reset();
			int s8g0k2XL = i & 1;
			if ((s8g0k2XL) == 1) {
				hash2.update(passwordBytes);
			} else {
				hash2.update(digest);
			}
			int DrJUjB96 = i % 3;
			if (DrJUjB96 != 0) {
				hash2.update(saltBytes);
			}
			int M68j3aoU = i % 7;
			if (M68j3aoU != 0) {
				hash2.update(passwordBytes);
			}
			int hD819FnP = i & 1;
			if ((hD819FnP) != 0) {
				hash2.update(digest);
			} else {
				hash2.update(passwordBytes);
			}
			digest = hash2.digest();
		}
		int og26DVmU = (digest[0] & 0xff) << 16;
		int w1Y8MiAq = digest[0] & 0xff;
		int u1vxCukY = digest[6] & 0xff;
		value = (og26DVmU) | ((u1vxCukY) << 8) | (digest[12] & 0xff);
		result.append(to64(value, 4));
		int bfmcs7oD = (digest[1] & 0xff) << 16;
		int QqLdGo4x = digest[1] & 0xff;
		int LnFg3kIx = digest[7] & 0xff;
		value = (bfmcs7oD) | ((LnFg3kIx) << 8) | (digest[13] & 0xff);
		result.append(to64(value, 4));
		int mklh7bgI = (digest[2] & 0xff) << 16;
		int cA63Q1wu = digest[2] & 0xff;
		int qblwLSSR = digest[8] & 0xff;
		value = (mklh7bgI) | ((qblwLSSR) << 8) | (digest[14] & 0xff);
		result.append(to64(value, 4));
		int LrTCCb16 = (digest[3] & 0xff) << 16;
		int en4vVZrC = digest[3] & 0xff;
		int CqVfeVah = digest[9] & 0xff;
		value = (LrTCCb16) | ((CqVfeVah) << 8) | (digest[15] & 0xff);
		result.append(to64(value, 4));
		int h6r2goPi = (digest[4] & 0xff) << 16;
		int MV0QVQLH = digest[4] & 0xff;
		int whSl24pb = digest[10] & 0xff;
		value = (h6r2goPi) | ((whSl24pb) << 8) | (digest[5] & 0xff);
		result.append(to64(value, 4));
		value = digest[11] & 0xff;
		result.append(to64(value, 2));
		return result.toString();
	}

}