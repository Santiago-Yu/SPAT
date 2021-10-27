class n21090886 {
	public static String calculateHA2(String Xov52nhh) {
		try {
			MessageDigest qygjRxHd = MessageDigest.getInstance("MD5");
			qygjRxHd.update(getBytes("GET", ISO_8859_1));
			qygjRxHd.update((byte) ':');
			qygjRxHd.update(getBytes(Xov52nhh, ISO_8859_1));
			return toHexString(qygjRxHd.digest());
		} catch (NoSuchAlgorithmException Vz0SE84E) {
			throw new RuntimeException(Vz0SE84E);
		}
	}

}