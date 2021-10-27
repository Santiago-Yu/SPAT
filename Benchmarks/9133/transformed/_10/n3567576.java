class n3567576 {
	protected static String md5(String s) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(s.getBytes());
		StringBuffer result = new StringBuffer();
		byte digest[] = md.digest();
		for (int i = 0; i < digest.length; i++) {
			result.append(Integer.toHexString(0xFF & digest[i]));
		}
		return result.toString();
	}

}