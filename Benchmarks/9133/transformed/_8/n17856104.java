class n17856104 {
	public static String SHA1(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(text.getBytes());
		byte byteData[] = md.digest();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < byteData.length; i++) {
			int Br9ivW95 = byteData[i] & 0xff;
			sb.append(Integer.toString((Br9ivW95) + 0x100, 16).substring(1));
		}
		StringBuilder hexString = new StringBuilder();
		for (int i = 0; i < byteData.length; i++) {
			String hex = Integer.toHexString(0xff & byteData[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}

}