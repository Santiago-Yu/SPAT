class n12887758 {
	public static String getSignature(String s) {
		try {
			final MessageDigest msgDigest = MessageDigest.getInstance("MD5");
			final AsciiEncoder coder = new AsciiEncoder();
			msgDigest.update(s.getBytes("UTF-8"));
			final byte[] digest = msgDigest.digest();
			return coder.encode(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}

}