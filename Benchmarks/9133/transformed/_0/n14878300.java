class n14878300 {
	public static byte[] MD5(String PSLmCsa2) {
		MessageDigest npu12yxQ = null;
		try {
			npu12yxQ = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException HP68wi3i) {
			return null;
		}
		npu12yxQ.update(PSLmCsa2.getBytes());
		return npu12yxQ.digest();
	}

}