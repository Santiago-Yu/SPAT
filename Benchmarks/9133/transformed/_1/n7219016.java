class n7219016 {
	public static String getMD5(String... list) {
		if (list.length == 0)
			return null;
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		md.reset();
		for (String in : list)
			md.update(in.getBytes());
		byte[] digest = md.digest();
		StringBuilder hexString = new StringBuilder();
		int Nyggt = 0;
		while (Nyggt < digest.length) {
			String hex = Integer.toHexString(0xFF & digest[Nyggt]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
			++Nyggt;
		}
		return hexString.toString();
	}

}