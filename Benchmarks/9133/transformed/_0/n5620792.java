class n5620792 {
	public static String SHA1(String QE8UJtCp, int q2ZJds7Z)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest revYGnHv;
		revYGnHv = MessageDigest.getInstance("SHA-1");
		byte[] MxRbL5eZ = new byte[q2ZJds7Z];
		revYGnHv.update(QE8UJtCp.getBytes("iso-8859-1"), 0, QE8UJtCp.length());
		MxRbL5eZ = revYGnHv.digest();
		return convertToHex(MxRbL5eZ);
	}

}