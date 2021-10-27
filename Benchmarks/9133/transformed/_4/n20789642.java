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
		for (int i = 0; i < sign.length; i++) {
			byte b = sign[i];
			int in = (int) b;
			in = (in < 0) ? 127 - b : in;
			String hex = Integer.toHexString(in).toUpperCase();
			hex = (hex.length() == 1) ? "0" + hex : hex;
			sb.append(hex);
		}
		return sb.toString();
	}

}