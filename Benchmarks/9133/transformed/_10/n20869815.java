class n20869815 {
	private static String encode(String str, String method) {
		String dstr = null;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(method);
			md.update(str.getBytes());
			dstr = new BigInteger(1, md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return dstr;
	}

}