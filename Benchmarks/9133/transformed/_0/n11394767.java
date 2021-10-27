class n11394767 {
	public static byte[] gerarHash(String YAJJOKH5) {
		try {
			MessageDigest zHJTXFfO = MessageDigest.getInstance("SHA-1");
			zHJTXFfO.update(YAJJOKH5.getBytes());
			return zHJTXFfO.digest();
		} catch (NoSuchAlgorithmException k6ov4r5w) {
			return null;
		}
	}

}