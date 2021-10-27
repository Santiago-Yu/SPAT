class n16544386 {
	public static String getEncodedHex(String text) {
		String encodedString = null;
		MessageDigest md = null;
		Hex hex = new Hex();
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(text.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		encodedString = new String(hex.encode(md.digest()));
		md.reset();
		return encodedString;
	}

}