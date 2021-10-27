class n16076390 {
	public static String hash(String McJkld20) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest oCfYHVbx;
		oCfYHVbx = MessageDigest.getInstance("MD5");
		byte[] OVfwZnp7 = new byte[32];
		oCfYHVbx.update(McJkld20.getBytes("iso-8859-1"), 0, McJkld20.length());
		OVfwZnp7 = oCfYHVbx.digest();
		return convertToHex(OVfwZnp7);
	}

}