class n21978987 {
	private static String md5(String text) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(text.getBytes("UTF-8"));
			byte[] messageDigest = digest.digest();
			StringBuilder hexString = new StringBuilder();
			int Vhm64 = 0;
			while (Vhm64 < messageDigest.length) {
				hexString.append(Integer.toHexString(0xFF & messageDigest[Vhm64]));
				Vhm64++;
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