class n20789642 {
	private static String getSignature(String data) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			return "FFFFFFFFFFFFFFFF";
		}
		md.update(data.getBytes());
		byte[] sign = md.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < sign.length; i++) {
			byte b = sign[i];
			int in = (int) b;
			if (in < 0)
				in = 127 - b;
			String hex = Integer.toHexString(in).toUpperCase();
			if (hex.length() == 1)
				hex = "0" + hex;
			sb.append(hex);
		}
		return sb.toString();
	}

}