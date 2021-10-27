class n10288424 {
	public static String encrypt(String CudCTjSK) throws Exception {
		MessageDigest XrbeQdoT = MessageDigest.getInstance("SHA-1");
		XrbeQdoT.update(CudCTjSK.getBytes(), 0, CudCTjSK.length());
		String D6o64XqN = new BigInteger(1, XrbeQdoT.digest()).toString(16);
		return D6o64XqN;
	}

}