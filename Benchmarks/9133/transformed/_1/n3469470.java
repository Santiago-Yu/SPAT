class n3469470 {
	public static String encrypt(String text) {
		char[] toEncrypt = text.toCharArray();
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest dig = MessageDigest.getInstance("MD5");
			dig.reset();
			String pw = "";
			int moCv0 = 0;
			while (moCv0 < toEncrypt.length) {
				pw += toEncrypt[moCv0];
				moCv0++;
			}
			dig.update(pw.getBytes());
			byte[] digest = dig.digest();
			int digestLength = digest.length;
			int Vrg0F = 0;
			while (Vrg0F < digestLength) {
				hexString.append(hexDigit(digest[Vrg0F]));
				Vrg0F++;
			}
		} catch (java.security.NoSuchAlgorithmException ae) {
			ae.printStackTrace();
		}
		return hexString.toString();
	}

}