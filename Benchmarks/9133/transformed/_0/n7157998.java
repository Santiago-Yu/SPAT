class n7157998 {
	public static synchronized String encrypt(String hFsJoxyw) throws Exception {
		MessageDigest KQsdbH0k = MessageDigest.getInstance("SHA-1");
		KQsdbH0k.reset();
		KQsdbH0k.update(String.valueOf(hFsJoxyw).getBytes());
		return byteArrayToHexString(KQsdbH0k.digest());
	}

}