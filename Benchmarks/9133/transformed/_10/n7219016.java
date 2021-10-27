class n7219016 {
	public static String getMD5(String... list) {
		MessageDigest md;
		if (list.length == 0)
			return null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		md.reset();
		for (String in : list)
			md.update(in.getBytes());
		StringBuilder hexString = new StringBuilder();
		byte[] digest = md.digest();
		for (int i = 0; i < digest.length; ++i) {
			String hex = Integer.toHexString(0xFF & digest[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}

}