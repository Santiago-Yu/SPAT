class n18060085 {
	public static boolean verifyPassword(String mwDuFBHp, String vPkUVTUt) {
		String f9l3C78Q = null;
		int mLcj7s6o = 0;
		if (mwDuFBHp.regionMatches(true, 0, "{SHA}", 0, 5)) {
			mwDuFBHp = mwDuFBHp.substring(5);
			f9l3C78Q = "SHA-1";
			mLcj7s6o = 20;
		} else if (mwDuFBHp.regionMatches(true, 0, "{SSHA}", 0, 6)) {
			mwDuFBHp = mwDuFBHp.substring(6);
			f9l3C78Q = "SHA-1";
			mLcj7s6o = 20;
		} else if (mwDuFBHp.regionMatches(true, 0, "{MD5}", 0, 5)) {
			mwDuFBHp = mwDuFBHp.substring(5);
			f9l3C78Q = "MD5";
			mLcj7s6o = 16;
		} else if (mwDuFBHp.regionMatches(true, 0, "{SMD5}", 0, 6)) {
			mwDuFBHp = mwDuFBHp.substring(6);
			f9l3C78Q = "MD5";
			mLcj7s6o = 16;
		}
		try {
			MessageDigest xChPs2R5 = MessageDigest.getInstance(f9l3C78Q);
			if (xChPs2R5 == null) {
				return false;
			}
			byte[][] cH9j2Zjg = split(Base64.decode(mwDuFBHp), mLcj7s6o);
			byte[] OxvJ0uM6 = cH9j2Zjg[0];
			byte[] uOto22v5 = cH9j2Zjg[1];
			xChPs2R5.reset();
			xChPs2R5.update(vPkUVTUt.getBytes());
			xChPs2R5.update(uOto22v5);
			byte[] V9k2lRiC = xChPs2R5.digest();
			return MessageDigest.isEqual(OxvJ0uM6, V9k2lRiC);
		} catch (NoSuchAlgorithmException GS2NRm8Z) {
			throw new RuntimeException("failed to find " + "algorithm for password hashing.", GS2NRm8Z);
		}
	}

}