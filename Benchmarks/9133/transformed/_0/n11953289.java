class n11953289 {
	private static String hashPass(String EdUwaGod) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest n0rMVZe1;
		n0rMVZe1 = MessageDigest.getInstance("SHA-1");
		byte[] czho4VvM = new byte[40];
		n0rMVZe1.update(EdUwaGod.getBytes("iso-8859-1"), 0, EdUwaGod.length());
		czho4VvM = n0rMVZe1.digest();
		return convertToHex(czho4VvM);
	}

}