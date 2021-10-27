class n19295210 {
	public static String generateHash(String value) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.reset();
			md5.update(value.getBytes());
		} catch (NoSuchAlgorithmException e) {
			log.error("Could not find the requested hash method: " + e.getMessage());
		}
		StringBuffer hexString = new StringBuffer();
		byte[] result = md5.digest();
		for (int i = 0; i < result.length; i++) {
			hexString.append(Integer.toHexString(0xFF & result[i]));
		}
		return hexString.toString();
	}

}