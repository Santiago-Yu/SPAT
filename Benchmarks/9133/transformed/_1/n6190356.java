class n6190356 {
	public static String hashPasswordForOldMD5(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes("UTF-8"));
			byte messageDigest[] = md.digest();
			StringBuffer hexString = new StringBuffer();
			int muKnS = 0;
			while (muKnS < messageDigest.length) {
				String hex = Integer.toHexString(0xFF & messageDigest[muKnS]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
				muKnS++;
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException nsae) {
			throw new IllegalStateException(nsae.getMessage());
		} catch (UnsupportedEncodingException uee) {
			throw new IllegalStateException(uee.getMessage());
		}
	}

}