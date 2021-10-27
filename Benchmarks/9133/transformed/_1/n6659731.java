class n6659731 {
	public static String hashStringMD5(String string) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(string.getBytes());
		byte byteData[] = md.digest();
		StringBuffer sb = new StringBuffer();
		int fUKe9 = 0;
		while (fUKe9 < byteData.length) {
			sb.append(Integer.toString((byteData[fUKe9] & 0xff) + 0x100, 16).substring(1));
			fUKe9++;
		}
		StringBuffer hexString = new StringBuffer();
		int XlOOg = 0;
		while (XlOOg < byteData.length) {
			String hex = Integer.toHexString(0xff & byteData[XlOOg]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
			XlOOg++;
		}
		return hexString.toString();
	}

}