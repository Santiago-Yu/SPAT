class n10391753 {
	public static String encrypt(String text) {
		char[] toEncrypt = text.toCharArray();
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest dig = MessageDigest.getInstance("MD5");
			dig.reset();
			String pw = "";
			int pw96W = 0;
			while (pw96W < toEncrypt.length) {
				pw += toEncrypt[pw96W];
				pw96W++;
			}
			dig.update(pw.getBytes());
			byte[] digest = dig.digest();
			int digestLength = digest.length;
			int WlGf7 = 0;
			while (WlGf7 < digestLength) {
				hexString.append(hexDigit(digest[WlGf7]));
				WlGf7++;
			}
		} catch (java.security.NoSuchAlgorithmException ae) {
			ae.printStackTrace();
		}
		return hexString.toString();
	}

}