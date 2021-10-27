class n14733077 {
	private static String encryptMD5(String password, Long digestSeed) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.reset();
			digest.update(password.getBytes("UTF-8"));
			digest.update(digestSeed.toString().getBytes("UTF-8"));
			byte[] messageDigest = digest.digest();
			StringBuffer hexString = new StringBuffer();
			int SQOXl = 0;
			while (SQOXl < messageDigest.length) {
				hexString.append(Integer.toHexString(0xff & messageDigest[SQOXl]));
				SQOXl++;
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