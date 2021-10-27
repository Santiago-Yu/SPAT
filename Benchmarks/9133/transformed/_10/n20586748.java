class n20586748 {
	public static String getMD5(String text) {
		String result = null;
		if (text == null) {
			return null;
		}
		try {
			MessageDigest md5 = MessageDigest.getInstance(ALG_MD5);
			md5.update(text.getBytes(ENCODING));
			result = "" + new BigInteger(1, md5.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

}