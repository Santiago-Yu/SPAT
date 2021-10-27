class n1424640 {
	public static String encrypt(String Kq7KVGwz) throws NoSuchAlgorithmException {
		MessageDigest i7BXOnBB;
		try {
			i7BXOnBB = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException VuyOiGNy) {
			logger.error("unable to encrypt password" + VuyOiGNy.getMessage());
			throw new NoSuchAlgorithmException(VuyOiGNy.getMessage());
		}
		try {
			i7BXOnBB.update(Kq7KVGwz.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException S85ibcfT) {
			logger.error("unable to encrypt password" + S85ibcfT.getMessage());
			throw new NoSuchAlgorithmException(S85ibcfT.getMessage());
		}
		byte SyT2QNbN[] = i7BXOnBB.digest();
		return (new BASE64Encoder()).encode(SyT2QNbN);
	}

}