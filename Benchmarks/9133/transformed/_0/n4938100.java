class n4938100 {
	public static String sha1(String R6oyPaYf) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest ALLcM5Mb;
		ALLcM5Mb = MessageDigest.getInstance("SHA-1");
		byte[] K3QCqDE0 = new byte[40];
		ALLcM5Mb.update(R6oyPaYf.getBytes("iso-8859-1"), 0, R6oyPaYf.length());
		K3QCqDE0 = ALLcM5Mb.digest();
		return convertToHex(K3QCqDE0);
	}

}