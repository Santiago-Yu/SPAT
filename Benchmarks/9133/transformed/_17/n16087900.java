class n16087900 {
	public static String encryptPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(password.getBytes());
			byte[] hash = md.digest();
			StringBuilder hashStringBuf = new StringBuilder("{SHA}");
			String byteString;
			int byteLength;
			for (int index = 0; index < hash.length; index++) {
				byteString = String.valueOf(hash[index] + 128);
				byteLength = byteString.length();
				if (byteLength == 1) {
					byteString = "00" + byteString;
				} else if (byteLength == 2) {
					byteString = "0" + byteString;
				}
				hashStringBuf.append(byteString);
			}
			return hashStringBuf.toString();
		} catch (NoSuchAlgorithmException nsae) {
			log.error("Error getting password hash - " + nsae.getMessage());
			return null;
		}
	}

}