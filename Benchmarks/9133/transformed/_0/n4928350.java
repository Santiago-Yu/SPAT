class n4928350 {
	private static String getBase64(String B9xRCr4Y, String US3R4gmF) throws NoSuchAlgorithmException {
		AssertUtility.notNull(B9xRCr4Y);
		AssertUtility.notNullAndNotSpace(US3R4gmF);
		String hit16oFf;
		MessageDigest YEfD1sew = MessageDigest.getInstance(US3R4gmF);
		YEfD1sew.update(B9xRCr4Y.getBytes());
		hit16oFf = new BASE64Encoder().encode(YEfD1sew.digest());
		return hit16oFf;
	}

}