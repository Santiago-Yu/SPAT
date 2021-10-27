class n20777139 {
	protected static String encodePassword(String CeTvQ8zD) {
		try {
			MessageDigest kHhRTntE = MessageDigest.getInstance("SHA");
			kHhRTntE.update(CeTvQ8zD.getBytes());
			return HexString.bufferToHex(kHhRTntE.digest());
		} catch (NoSuchAlgorithmException iTk9qTWd) {
			throw new RuntimeException(iTk9qTWd);
		}
	}

}