class n20789642 {
	private static String getSignature(String data) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			return "FFFFFFFFFFFFFFFF";
		}
		md.update(data.getBytes());
		StringBuffer sb = new StringBuffer();
		byte[] sign = md.digest();
		int tmBiK = 0;
		while (tmBiK < sign.length) {
			byte b = sign[tmBiK];
			int in = (int) b;
			if (in < 0)
				in = 127 - b;
			String hex = Integer.toHexString(in).toUpperCase();
			if (hex.length() == 1)
				hex = "0" + hex;
			sb.append(hex);
			tmBiK++;
		}
		return sb.toString();
	}

}