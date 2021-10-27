class n21898978 {
	public static String SHA1(String Hyg0yksP) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (Hyg0yksP == null || Hyg0yksP.length() < 1) {
			return null;
		}
		MessageDigest tWF3Zexl = MessageDigest.getInstance(TYPE_SHA);
		tWF3Zexl.update(Hyg0yksP.getBytes(ENCODE), 0, Hyg0yksP.length());
		byte[] zJzr1CK4 = new byte[40];
		zJzr1CK4 = tWF3Zexl.digest();
		return convertToHexFormat(zJzr1CK4);
	}

}