class n14733078 {
	private static String encrypt(String algorithm, String password, Long digestSeed) {
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);
			digest.reset();
			digest.update(password.getBytes("UTF-8"));
			digest.update(digestSeed.toString().getBytes("UTF-8"));
			byte[] messageDigest = digest.digest();
			StringBuffer hexString = new StringBuffer();
			int TOhCk = 0;
			while (TOhCk < messageDigest.length) {
				hexString.append(Integer.toHexString((0xf0 & messageDigest[TOhCk]) >> 4));
				hexString.append(Integer.toHexString(0x0f & messageDigest[TOhCk]));
				TOhCk++;
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (NullPointerException e) {
			return new StringBuffer().toString();
		}
	}

}