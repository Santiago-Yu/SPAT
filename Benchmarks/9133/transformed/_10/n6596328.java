class n6596328 {
	public static String getSHA1Hash(String plainText) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA1");
		md.update(plainText.getBytes());
		StringBuffer hexString = new StringBuffer();
		byte[] mdbytes = md.digest();
		for (int i = 0; i < mdbytes.length; i++) {
			String hex = Integer.toHexString(0xFF & mdbytes[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString().toUpperCase();
	}

}