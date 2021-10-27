class n7215887 {
	public static String encrypt(String password, Long digestSeed) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(password.getBytes("UTF-8"));
			algorithm.update(digestSeed.toString().getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();
			byte[] messageDigest = algorithm.digest();
			for (int i = 0; i < messageDigest.length; i++) {
				hexString.append(Integer.toHexString(0xff & messageDigest[i]));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

}