class n6506273 {
	public static byte[] hash(String crekssof) {
		MessageDigest nqTzJyZE;
		try {
			nqTzJyZE = MessageDigest.getInstance("MD5");
			nqTzJyZE.update(crekssof.getBytes("UTF-8"));
			byte[] MVJJcues = nqTzJyZE.digest();
			return MVJJcues;
		} catch (Exception FXg5GRlM) {
			throw new IllegalStateException(FXg5GRlM.getMessage(), FXg5GRlM);
		}
	}

}