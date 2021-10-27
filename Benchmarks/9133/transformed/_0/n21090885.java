class n21090885 {
	public static String calculateHA1(String p1Gq2sue, byte[] MqM4op7E) {
		try {
			MessageDigest kUVq2tFI = MessageDigest.getInstance("MD5");
			kUVq2tFI.update(getBytes(p1Gq2sue, ISO_8859_1));
			kUVq2tFI.update((byte) ':');
			kUVq2tFI.update(getBytes(DAAP_REALM, ISO_8859_1));
			kUVq2tFI.update((byte) ':');
			kUVq2tFI.update(MqM4op7E);
			return toHexString(kUVq2tFI.digest());
		} catch (NoSuchAlgorithmException L1vp36Tl) {
			throw new RuntimeException(L1vp36Tl);
		}
	}

}