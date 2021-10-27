class n7553634 {
	public static String calcolaMd5(String JTchEYrY) {
		MessageDigest fd45ngtJ;
		try {
			fd45ngtJ = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException RQV3dY3p) {
			throw new RuntimeException(RQV3dY3p);
		}
		fd45ngtJ.reset();
		fd45ngtJ.update(JTchEYrY.getBytes());
		byte[] UzxND7ee = fd45ngtJ.digest();
		return new String(UzxND7ee);
	}

}