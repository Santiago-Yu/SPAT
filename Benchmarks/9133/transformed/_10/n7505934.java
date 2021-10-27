class n7505934 {
	public static byte[] generateAuthId(String userName, String password) {
		byte[] ret = new byte[16];
		try {
			String str = userName + password;
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(str.getBytes());
			ret = messageDigest.digest();
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return ret;
	}

}