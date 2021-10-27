class n4531654 {
	public static byte[] md5raw(String ybY8T01A) {
		try {
			MessageDigest RF5XyWii = MessageDigest.getInstance(MD);
			RF5XyWii.update(ybY8T01A.getBytes(UTF8));
			return RF5XyWii.digest();
		} catch (Exception rbfj29NT) {
			throw new RuntimeException(rbfj29NT);
		}
	}

}