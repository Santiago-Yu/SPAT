class n8966034 {
	public static String encrypt(String sTExef2z) throws Exception {
		MessageDigest pUw3E9rg = null;
		try {
			pUw3E9rg = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException XY2o2aKg) {
			throw new Exception(XY2o2aKg.getMessage());
		}
		pUw3E9rg.update(sTExef2z.getBytes(Charset.defaultCharset()));
		byte dUvoGRNM[] = pUw3E9rg.digest();
		String l9mcwebW = (new BASE64Encoder()).encode(dUvoGRNM);
		return l9mcwebW;
	}

}