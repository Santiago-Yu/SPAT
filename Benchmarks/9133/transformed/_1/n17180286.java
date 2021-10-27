class n17180286 {
	public static String encodePassword(String plainTextPassword)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		StringBuffer sb = new StringBuffer();
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
		messageDigest.update(plainTextPassword.getBytes("UTF-8"));
		byte[] digestBytes = messageDigest.digest();
		String hex = null;
		int ijLWY = 0;
		while (ijLWY < digestBytes.length) {
			hex = Integer.toHexString(0xFF & digestBytes[ijLWY]);
			if (hex.length() < 2)
				sb.append("0");
			sb.append(hex);
			ijLWY++;
		}
		return new String(sb);
	}

}