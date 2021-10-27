class n23541000 {
	public static boolean matchPassword(String prevPassStr, String newPassword)
			throws NoSuchAlgorithmException, java.io.IOException, java.io.UnsupportedEncodingException {
		byte[] seed = new byte[12];
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] prevPass = new sun.misc.BASE64Decoder().decodeBuffer(prevPassStr);
		System.arraycopy(prevPass, 0, seed, 0, 12);
		md.update(seed);
		md.update(newPassword.getBytes("UTF8"));
		byte[] choppedPrevPassword = new byte[prevPass.length - 12];
		byte[] digestNewPassword = md.digest();
		System.arraycopy(prevPass, 12, choppedPrevPassword, 0, prevPass.length - 12);
		boolean isMatching = Arrays.equals(digestNewPassword, choppedPrevPassword);
		return isMatching;
	}

}