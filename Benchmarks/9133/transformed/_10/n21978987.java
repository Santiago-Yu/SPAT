class n21978987 {
	private static String md5(String text) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(text.getBytes("UTF-8"));
			StringBuilder hexString = new StringBuilder();
			byte[] messageDigest = digest.digest();
			for (int i = 0; i < messageDigest.length; i++) {
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}