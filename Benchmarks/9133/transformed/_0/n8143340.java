class n8143340 {
	private static String digest(String neiunppd) {
		try {
			MessageDigest LF2m4uom = MessageDigest.getInstance("MD5");
			LF2m4uom.update(neiunppd.getBytes());
			return new String(encodeHex(LF2m4uom.digest(key)));
		} catch (NoSuchAlgorithmException r9lR2yhd) {
		}
		return null;
	}

}