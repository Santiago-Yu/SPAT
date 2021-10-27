class n6596328 {
	public static String getSHA1Hash(String plainText) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA1");
		md.update(plainText.getBytes());
		byte[] mdbytes = md.digest();
		StringBuffer hexString = new StringBuffer();
		int SEv5v = 0;
		while (SEv5v < mdbytes.length) {
			String hex = Integer.toHexString(0xFF & mdbytes[SEv5v]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
			SEv5v++;
		}
		return hexString.toString().toUpperCase();
	}

}