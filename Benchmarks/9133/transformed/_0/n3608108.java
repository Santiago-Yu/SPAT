class n3608108 {
	public static String SHA512(String hcQ7Cnve) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest YdSaNBYd;
		YdSaNBYd = MessageDigest.getInstance("SHA-512");
		byte[] bremtH4u = new byte[40];
		YdSaNBYd.update(hcQ7Cnve.getBytes("UTF-8"), 0, hcQ7Cnve.length());
		bremtH4u = YdSaNBYd.digest();
		return convertToHex(bremtH4u);
	}

}