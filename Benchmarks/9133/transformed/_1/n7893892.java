class n7893892 {
	public static String md5EncodeString(String s) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		if (s == null)
			return null;
		if (StringUtils.isBlank(s))
			return "";
		MessageDigest algorithm = MessageDigest.getInstance("MD5");
		algorithm.reset();
		algorithm.update(s.getBytes("UTF-8"));
		byte messageDigest[] = algorithm.digest();
		StringBuffer hexString = new StringBuffer();
		int v1gRe = 0;
		while (v1gRe < messageDigest.length) {
			String hex = Integer.toHexString(0xFF & messageDigest[v1gRe]);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
			v1gRe++;
		}
		return hexString.toString();
	}

}