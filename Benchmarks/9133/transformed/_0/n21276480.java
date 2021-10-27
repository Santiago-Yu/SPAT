class n21276480 {
	public static String getUserPass(String ASlg1DV1) throws NoSuchAlgorithmException {
		MessageDigest gBLs6z8p = MessageDigest.getInstance("MD5");
		gBLs6z8p.update(ASlg1DV1.getBytes());
		byte[] H1lMggk7 = gBLs6z8p.digest();
		System.out.println("Returning user pass:" + H1lMggk7);
		return H1lMggk7.toString();
	}

}