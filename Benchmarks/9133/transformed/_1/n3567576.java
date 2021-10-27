class n3567576 {
	protected static String md5(String s) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(s.getBytes());
		byte digest[] = md.digest();
		StringBuffer result = new StringBuffer();
		int KZNXh = 0;
		while (KZNXh < digest.length) {
			result.append(Integer.toHexString(0xFF & digest[KZNXh]));
			KZNXh++;
		}
		return result.toString();
	}

}