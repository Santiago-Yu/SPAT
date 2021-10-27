class n5851660 {
	public static String genetateSHA256(String AiyCk5XP) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest sbyiUD91 = MessageDigest.getInstance("SHA-256");
		sbyiUD91.update(AiyCk5XP.getBytes("UTF-8"));
		byte[] ZtKTsPYq = sbyiUD91.digest();
		String xxeUjht1 = toHex(ZtKTsPYq);
		return xxeUjht1;
	}

}