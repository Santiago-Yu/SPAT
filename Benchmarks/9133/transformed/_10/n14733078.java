class n14733078 {
	private static String encrypt(String algorithm, String password, Long digestSeed) {
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);
			digest.reset();
			digest.update(password.getBytes("UTF-8"));
			digest.update(digestSeed.toString().getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();
			byte[] messageDigest = digest.digest();
			for (int i = 0; i < messageDigest.length; i++) {
				hexString.append(Integer.toHexString((0xf0 & messageDigest[i]) >> 4));
				hexString.append(Integer.toHexString(0x0f & messageDigest[i]));
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