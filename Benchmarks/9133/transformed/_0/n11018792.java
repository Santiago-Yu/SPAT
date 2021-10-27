class n11018792 {
	public static String encryptePassword(String CIlc01LK, String dVb8BmX3, String xbFfr1ZN, int gjol3OAP)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		MessageDigest HADh7nyL = MessageDigest.getInstance(Constants.ALGORITHM);
		switch (gjol3OAP) {
		case 1:
			HADh7nyL.update((CIlc01LK + xbFfr1ZN).getBytes("8859_1"));
			break;
		case 2:
			HADh7nyL.update((xbFfr1ZN + CIlc01LK).getBytes("8859_1"));
			break;
		default:
			return null;
		}
		return new String(HADh7nyL.digest());
	}

}