class n14638475 {
	public static String md5String(String string) {
		try {
			MessageDigest msgDigest = MessageDigest.getInstance("MD5");
			msgDigest.update(string.getBytes("UTF-8"));
			byte[] digest = msgDigest.digest();
			String result = "";
			for (int i = 0; i < digest.length; i++) {
				int value = digest[i];
				value = (value < 0) ? 256 : value;
				result += Integer.toHexString(value);
			}
			return result;
		} catch (UnsupportedEncodingException error) {
			throw new IllegalArgumentException(error);
		} catch (NoSuchAlgorithmException error) {
			throw new IllegalArgumentException(error);
		}
	}

}