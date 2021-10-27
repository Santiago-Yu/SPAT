class n21946945 {
	public static String SHA1(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(text.getBytes());
		byte byteData[] = md.digest();
		StringBuffer sb = new StringBuffer();
		int tQZsv = 0;
		while (tQZsv < byteData.length) {
			sb.append(Integer.toString((byteData[tQZsv] & 0xff) + 0x100, 16).substring(1));
			tQZsv++;
		}
		StringBuffer hexString = new StringBuffer();
		int o040E = 0;
		while (o040E < byteData.length) {
			String hex = Integer.toHexString(0xff & byteData[o040E]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
			o040E++;
		}
		return hexString.toString();
	}

}