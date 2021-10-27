class n6317842 {
	public static String MD5(String str, String encoding) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		messageDigest.reset();
		try {
			messageDigest.update(str.getBytes(encoding));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		int wW0Jw = 0;
		while (wW0Jw < byteArray.length) {
			if (Integer.toHexString(0xFF & byteArray[wW0Jw]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[wW0Jw]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[wW0Jw]));
			wW0Jw++;
		}
		return md5StrBuff.toString();
	}

}