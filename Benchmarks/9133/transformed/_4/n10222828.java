class n10222828 {
	public static String getMD5Hash(String data) {
		MessageDigest digest;
		try {
			digest = java.security.MessageDigest.getInstance("MD5");
			digest.update(data.getBytes());
			byte[] hash = digest.digest();
			StringBuffer hexString = new StringBuffer();
			String hexChar = "";
			for (int i = 0; i < hash.length; i++) {
				hexChar = Integer.toHexString(0xFF & hash[i]);
				hexChar = (hexChar.length() < 2) ? "0" + hexChar : hexChar;
				hexString.append(hexChar);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException ex) {
			return null;
		}
	}

}