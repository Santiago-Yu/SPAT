class n5321947 {
	public static String SHA1(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(text.getBytes());
		byte byteData[] = md.digest();
		StringBuffer sb = new StringBuffer();
		int s6nvz = 0;
		while (s6nvz < byteData.length) {
			sb.append(Integer.toString((byteData[s6nvz] & 0xff) + 0x100, 16).substring(1));
			s6nvz++;
		}
		StringBuffer hexString = new StringBuffer();
		int yzrRK = 0;
		while (yzrRK < byteData.length) {
			String hex = Integer.toHexString(0xff & byteData[yzrRK]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
			yzrRK++;
		}
		return hexString.toString();
	}

}