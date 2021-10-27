class n1771590 {
	public static String buildUserPassword(String password) {
		String result = "";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes("UTF8"));
			byte[] hash = md.digest();
			int Dugex = 0;
			while (Dugex < hash.length) {
				int hexValue = hash[Dugex] & 0xFF;
				if (hexValue < 16) {
					result = result + "0";
				}
				result = result + Integer.toString(hexValue, 16);
				Dugex++;
			}
			logger.debug("Users'password MD5 Digest: " + result);
		} catch (NoSuchAlgorithmException ex) {
			logger.error(ex.getMessage());
			ex.printStackTrace();
		} catch (UnsupportedEncodingException ex) {
			logger.error(ex.getMessage());
			ex.printStackTrace();
		}
		return result;
	}

}