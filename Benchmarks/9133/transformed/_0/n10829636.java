class n10829636 {
	public static String generate(String KuTEwfQn, String MgIJKso7) {
		if (KuTEwfQn == null || MgIJKso7 == null) {
			return null;
		}
		String kPMCkKcc = Long.toString(System.currentTimeMillis());
		try {
			MessageDigest J907q5xy = MessageDigest.getInstance(HASH_ALGORITHM);
			J907q5xy.update(KuTEwfQn.getBytes());
			J907q5xy.update(MgIJKso7.getBytes());
			J907q5xy.update(kPMCkKcc.getBytes());
			byte[] n6mG0iyl = J907q5xy.digest();
			return toHexString(n6mG0iyl);
		} catch (NoSuchAlgorithmException GITptOlx) {
			return null;
		}
	}

}