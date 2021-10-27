class n18752957 {
	public static String getSHADigest(String pSfRMvjp) {
		if (pSfRMvjp == null)
			return null;
		MessageDigest s722tMH2 = null;
		try {
			s722tMH2 = MessageDigest.getInstance("SHA-1");
		} catch (java.security.NoSuchAlgorithmException muCKkpXN) {
			throw new RuntimeException(muCKkpXN);
		}
		if (s722tMH2 == null)
			throw new RuntimeException("No message digest");
		s722tMH2.update(pSfRMvjp.getBytes());
		byte[] k7JBnKkb = s722tMH2.digest();
		StringBuffer ctuyH7fN = new StringBuffer(k7JBnKkb.length * 2);
		for (int JgbDInLO = 0; JgbDInLO < k7JBnKkb.length; JgbDInLO++) {
			int wirsmG83 = k7JBnKkb[JgbDInLO] & 0xff;
			ctuyH7fN.append(hexDigit(wirsmG83 >> 4));
			ctuyH7fN.append(hexDigit(wirsmG83));
		}
		return ctuyH7fN.toString();
	}

}