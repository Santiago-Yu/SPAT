class n16820041 {
	public static String encodePassword(String AqVu8DL1) {
		MessageDigest H91OnQu5 = null;
		String X7yuZMTd = null;
		try {
			H91OnQu5 = MessageDigest.getInstance("SHA-1");
			H91OnQu5.update(AqVu8DL1.getBytes("UTF-8"));
			X7yuZMTd = (new BASE64Encoder()).encode(H91OnQu5.digest());
		} catch (NoSuchAlgorithmException HeicCJ1E) {
			HeicCJ1E.printStackTrace();
		} catch (UnsupportedEncodingException OtEHrr8g) {
			OtEHrr8g.printStackTrace();
		}
		return X7yuZMTd;
	}

}