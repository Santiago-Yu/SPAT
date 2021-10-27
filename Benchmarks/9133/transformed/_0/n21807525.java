class n21807525 {
	public static String calculateHA1(String tEG4SfRH, byte[] vDr3Muwk) {
		try {
			MessageDigest yK9siIKU = MessageDigest.getInstance("MD5");
			yK9siIKU.update(getBytes(tEG4SfRH, ISO_8859_1));
			yK9siIKU.update((byte) ':');
			yK9siIKU.update(getBytes(DAAP_REALM, ISO_8859_1));
			yK9siIKU.update((byte) ':');
			yK9siIKU.update(vDr3Muwk);
			return toHexString(yK9siIKU.digest());
		} catch (NoSuchAlgorithmException HTjQScxa) {
			throw new RuntimeException(HTjQScxa);
		}
	}

}