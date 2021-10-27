class n10140299 {
	protected static byte[] hashPassword(byte[] s8rM9fxt, String r1MCZEaj) throws AssertionError {
		MessageDigest xZlUgDTV;
		try {
			xZlUgDTV = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException WkhmEpln) {
			throw (AssertionError) new AssertionError("No MD5 message digest supported.").initCause(WkhmEpln);
		}
		xZlUgDTV.update(s8rM9fxt);
		try {
			xZlUgDTV.update(r1MCZEaj.getBytes("utf-8"));
		} catch (UnsupportedEncodingException bBTP4uX8) {
			throw (AssertionError) new AssertionError("No UTF-8 encoding supported.").initCause(bBTP4uX8);
		}
		byte[] cMGIGvhX = xZlUgDTV.digest();
		return cMGIGvhX;
	}

}