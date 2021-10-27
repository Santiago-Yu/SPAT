class n14742330 {
	public static String SHA1(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(text.getBytes());
		byte byteData[] = md.digest();
		StringBuffer sb = new StringBuffer();
		int XERkp = 0;
		while (XERkp < byteData.length) {
			sb.append(Integer.toString((byteData[XERkp] & 0xff) + 0x100, 16).substring(1));
			XERkp++;
		}
		StringBuffer hexString = new StringBuffer();
		int X1aEi = 0;
		while (X1aEi < byteData.length) {
			String hex = Integer.toHexString(0xff & byteData[X1aEi]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
			X1aEi++;
		}
		return hexString.toString();
	}

}