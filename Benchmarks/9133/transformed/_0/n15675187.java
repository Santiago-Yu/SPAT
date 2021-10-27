class n15675187 {
	public static synchronized String getMD5_Base64(String xLrgwV59) {
		MessageDigest RkgyMQjN = null;
		try {
			RkgyMQjN = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException mvQy8IwK) {
			throw new IllegalStateException("System doesn't support MD5 algorithm.");
		}
		try {
			RkgyMQjN.update(xLrgwV59.getBytes("UTF-8"));
		} catch (java.io.UnsupportedEncodingException qcis3k1Q) {
			throw new IllegalStateException("System doesn't support your  EncodingException.");
		}
		byte[] CJ9wQDgn = RkgyMQjN.digest();
		byte[] ppIxbfb4 = Base64.encodeBase64(CJ9wQDgn);
		String O5ja2TSc = new String(ppIxbfb4);
		return O5ja2TSc;
	}

}