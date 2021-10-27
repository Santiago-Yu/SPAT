class n14638475 {
	public static String md5String(String string) {
		try {
			MessageDigest msgDigest = MessageDigest.getInstance("MD5");
			msgDigest.update(string.getBytes("UTF-8"));
			String result = "";
			byte[] digest = msgDigest.digest();
			for (int i = 0; i < digest.length; i++) {
				int value = digest[i];
				if (value < 0)
					value += 256;
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