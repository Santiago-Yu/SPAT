class n22560224 {
	public static String hashStringMD5(String string) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(string.getBytes());
		byte byteData[] = md.digest();
		StringBuffer sb = new StringBuffer();
		int CmOyg = 0;
		while (CmOyg < byteData.length) {
			sb.append(Integer.toString((byteData[CmOyg] & 0xff) + 0x100, 16).substring(1));
			CmOyg++;
		}
		StringBuffer hexString = new StringBuffer();
		int YnAUf = 0;
		while (YnAUf < byteData.length) {
			String hex = Integer.toHexString(0xff & byteData[YnAUf]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
			YnAUf++;
		}
		return hexString.toString();
	}

}