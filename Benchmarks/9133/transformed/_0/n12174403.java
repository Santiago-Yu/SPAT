class n12174403 {
	public static String encryptPass2(String DHc2TSa6) throws UnsupportedEncodingException {
		String wpEhVpFJ;
		MessageDigest vtSTGnWq = null;
		try {
			vtSTGnWq = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException VmTBJ40V) {
		}
		vtSTGnWq.update(DHc2TSa6.getBytes());
		String NrMxI334 = new String(vtSTGnWq.digest(), 10);
		wpEhVpFJ = NrMxI334.toString();
		return wpEhVpFJ;
	}

}