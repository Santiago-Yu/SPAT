class n3945916 {
	public static String MD5(String uSyG3aJJ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest Fugeu87F;
		Fugeu87F = MessageDigest.getInstance("MD5");
		byte[] pc2cgT1U;
		Fugeu87F.update(uSyG3aJJ.getBytes("iso-8859-1"), 0, uSyG3aJJ.length());
		pc2cgT1U = Fugeu87F.digest();
		return convertToHex(pc2cgT1U);
	}

}