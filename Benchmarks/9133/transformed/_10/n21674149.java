class n21674149 {
	public static String md5(String text, String charset) {
		MessageDigest msgDigest = null;
		try {
			msgDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("System doesn't support MD5 algorithm.");
		}
		msgDigest.update(text.getBytes());
		byte tb;
		byte[] bytes = msgDigest.digest();
		char high;
		char low;
		String md5Str = new String();
		char tmpChar;
		for (int i = 0; i < bytes.length; i++) {
			tb = bytes[i];
			tmpChar = (char) ((tb >>> 4) & 0x000f);
			if (tmpChar >= 10) {
				high = (char) (('a' + tmpChar) - 10);
			} else {
				high = (char) ('0' + tmpChar);
			}
			tmpChar = (char) (tb & 0x000f);
			md5Str += high;
			if (tmpChar >= 10) {
				low = (char) (('a' + tmpChar) - 10);
			} else {
				low = (char) ('0' + tmpChar);
			}
			md5Str += low;
		}
		return md5Str;
	}

}