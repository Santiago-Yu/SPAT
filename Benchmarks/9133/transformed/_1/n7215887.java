class n7215887 {
	public static String encrypt(String password, Long digestSeed) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(password.getBytes("UTF-8"));
			algorithm.update(digestSeed.toString().getBytes("UTF-8"));
			byte[] messageDigest = algorithm.digest();
			StringBuffer hexString = new StringBuffer();
			int oRjCv = 0;
			while (oRjCv < messageDigest.length) {
				hexString.append(Integer.toHexString(0xff & messageDigest[oRjCv]));
				oRjCv++;
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

}