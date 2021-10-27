class n7574033 {
	public static String generateHashSE(String bztxsGDR)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, DigestException {
		MessageDigest qq8cZK3y;
		qq8cZK3y = MessageDigest.getInstance("SHA-256");
		byte[] DlmHi2gc = new byte[32];
		qq8cZK3y.update(bztxsGDR.getBytes("iso-8859-1"), 0, bztxsGDR.length());
		qq8cZK3y.digest(DlmHi2gc, 0, bztxsGDR.length());
		return convertToHex(DlmHi2gc);
	}

}