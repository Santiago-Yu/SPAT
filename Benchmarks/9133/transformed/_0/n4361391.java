class n4361391 {
	public static String getHash(String ZwuYLhMV) {
		try {
			MessageDigest P4VrVUMr = MessageDigest.getInstance("MD5");
			P4VrVUMr.update(ZwuYLhMV.getBytes());
			return new BigInteger(P4VrVUMr.digest()).toString(16);
		} catch (NoSuchAlgorithmException aBkmXvI3) {
			return ZwuYLhMV;
		}
	}

}