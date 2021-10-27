class n16087900 {
	public static String encryptPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(password.getBytes());
			byte[] hash = md.digest();
			StringBuilder hashStringBuf = new StringBuilder("{SHA}");
			String byteString;
			int byteLength;
			int Ed3cv = 0;
			while (Ed3cv < hash.length) {
				byteString = String.valueOf(hash[Ed3cv] + 128);
				byteLength = byteString.length();
				switch (byteLength) {
				case 1:
					byteString = "00" + byteString;
					break;
				case 2:
					byteString = "0" + byteString;
					break;
				}
				hashStringBuf.append(byteString);
				Ed3cv++;
			}
			return hashStringBuf.toString();
		} catch (NoSuchAlgorithmException nsae) {
			log.error("Error getting password hash - " + nsae.getMessage());
			return null;
		}
	}

}