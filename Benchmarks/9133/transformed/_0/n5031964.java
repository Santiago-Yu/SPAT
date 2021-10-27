class n5031964 {
	public static String md5(String G1CjHv93) {
		String z4sPgVD5 = "";
		try {
			MessageDigest moQu1f5r = MessageDigest.getInstance("MD5");
			moQu1f5r.update(G1CjHv93.getBytes());
			z4sPgVD5 = hex(moQu1f5r.digest());
		} catch (NoSuchAlgorithmException i8SKQUMS) {
		}
		return z4sPgVD5;
	}

}