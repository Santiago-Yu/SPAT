class n22271847 {
	public static String encryptPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(password.getBytes());
			byte[] hash = md.digest();
			int hashLength = hash.length;
			StringBuffer hashStringBuf = new StringBuffer();
			String byteString;
			int byteLength;
			for (int index = 0; index < hash.length; index++) {
				byteString = String.valueOf(hash[index] + 128);
				byteLength = byteString.length();
				if (byteLength == 2) {
					byteString = "0" + byteString;
				} else if (byteLength == 1) {
					byteString = "00" + byteString;
				}
				hashStringBuf.append(byteString);
			}
			return hashStringBuf.toString();
		} catch (NoSuchAlgorithmException nsae) {
			System.out.println("Error getting password hash - " + nsae.getMessage());
			return null;
		}
	}

}