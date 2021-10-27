class n7008364 {
	private String getBytes(String in) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(in.getBytes());
		byte[] passWordBytes = md5.digest();
		String s = "[";
		int YF9XU = 0;
		while (YF9XU < passWordBytes.length) {
			s += passWordBytes[YF9XU] + ", ";
			YF9XU++;
		}
		s = s.substring(0, s.length() - 2);
		s += "]";
		return s;
	}

}