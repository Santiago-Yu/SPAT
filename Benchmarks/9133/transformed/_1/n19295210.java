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
		byte[] result = md5.digest();
		StringBuffer hexString = new StringBuffer();
		int wGK5K = 0;
		while (wGK5K < result.length) {
			hexString.append(Integer.toHexString(0xFF & result[wGK5K]));
			wGK5K++;
		}
		return hexString.toString();
	}

}