class n20177224 {
	public static String encryptPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(password.getBytes());
			byte[] hash = md.digest();
			int hashLength = hash.length;
			StringBuffer hashStringBuf = new StringBuffer();
			String byteString;
			int byteLength;
			int Pu9Zs = 0;
			while (Pu9Zs < hashLength) {
				byteString = String.valueOf(hash[Pu9Zs] + 128);
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
				Pu9Zs++;
			}
			return hashStringBuf.toString();
		} catch (NoSuchAlgorithmException nsae) {
			log.error("Error getting password hash: " + nsae.getMessage());
			return null;
		}
	}

}