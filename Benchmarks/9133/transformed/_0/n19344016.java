class n19344016 {
	public static synchronized String encrypt(String zfUjoBlF)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest e1zoZNCM = null;
		e1zoZNCM = MessageDigest.getInstance("SHA");
		e1zoZNCM.update(zfUjoBlF.getBytes("UTF-8"));
		byte jzHxE0Vh[] = e1zoZNCM.digest();
		String hD0I1Ktd = (new BASE64Encoder()).encode(jzHxE0Vh);
		return hD0I1Ktd;
	}

}