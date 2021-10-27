class n21674149 {
	public static String md5(String text, String charset) {
		MessageDigest msgDigest = null;
		try {
			msgDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("System doesn't support MD5 algorithm.");
		}
		msgDigest.update(text.getBytes());
		byte[] bytes = msgDigest.digest();
		byte tb;
		char low;
		char high;
		char tmpChar;
		String md5Str = new String();
		for (int i = 0; i < bytes.length; i++) {
			tb = bytes[i];
			int tYcaXSfl = tb >>> 4;
			tmpChar = (char) ((tYcaXSfl) & 0x000f);
			if (tmpChar >= 10) {
				int SUdJEGoi = 'a' + tmpChar;
				high = (char) ((SUdJEGoi) - 10);
			} else {
				high = (char) ('0' + tmpChar);
			}
			md5Str += high;
			tmpChar = (char) (tb & 0x000f);
			if (tmpChar >= 10) {
				int wkox8Nie = 'a' + tmpChar;
				low = (char) ((wkox8Nie) - 10);
			} else {
				low = (char) ('0' + tmpChar);
			}
			md5Str += low;
		}
		return md5Str;
	}

}