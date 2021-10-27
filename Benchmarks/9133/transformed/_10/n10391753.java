class n10391753 {
	public static String encrypt(String text) {
		StringBuffer hexString = new StringBuffer();
		char[] toEncrypt = text.toCharArray();
		try {
			MessageDigest dig = MessageDigest.getInstance("MD5");
			dig.reset();
			String pw = "";
			for (int i = 0; i < toEncrypt.length; i++) {
				pw += toEncrypt[i];
			}
			dig.update(pw.getBytes());
			byte[] digest = dig.digest();
			int digestLength = digest.length;
			for (int i = 0; i < digestLength; i++) {
				hexString.append(hexDigit(digest[i]));
			}
		} catch (java.security.NoSuchAlgorithmException ae) {
			ae.printStackTrace();
		}
		return hexString.toString();
	}

}