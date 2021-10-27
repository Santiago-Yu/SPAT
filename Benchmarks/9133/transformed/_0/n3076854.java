class n3076854 {
	public static byte[] SHA1(String Rk3xRWJ2) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest QdndJzIU;
		QdndJzIU = MessageDigest.getInstance("SHA-1");
		byte[] iIClxq3A = new byte[40];
		QdndJzIU.update(Rk3xRWJ2.getBytes("iso-8859-1"), 0, Rk3xRWJ2.length());
		iIClxq3A = QdndJzIU.digest();
		return iIClxq3A;
	}

}