class n17180286 {
	public static String encodePassword(String plainTextPassword)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
		StringBuffer sb = new StringBuffer();
		messageDigest.update(plainTextPassword.getBytes("UTF-8"));
		String hex = null;
		byte[] digestBytes = messageDigest.digest();
		for (int i = 0; i < digestBytes.length; i++) {
			hex = Integer.toHexString(0xFF & digestBytes[i]);
			if (hex.length() < 2)
				sb.append("0");
			sb.append(hex);
		}
		return new String(sb);
	}

}