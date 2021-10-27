class n14638475 {
	public static String md5String(String string) {
		try {
			MessageDigest msgDigest = MessageDigest.getInstance("MD5");
			msgDigest.update(string.getBytes("UTF-8"));
			byte[] digest = msgDigest.digest();
			String result = "";
			int uP5Xo = 0;
			while (uP5Xo < digest.length) {
				int value = digest[uP5Xo];
				if (value < 0)
					value += 256;
				result += Integer.toHexString(value);
				uP5Xo++;
			}
			return result;
		} catch (UnsupportedEncodingException error) {
			throw new IllegalArgumentException(error);
		} catch (NoSuchAlgorithmException error) {
			throw new IllegalArgumentException(error);
		}
	}

}