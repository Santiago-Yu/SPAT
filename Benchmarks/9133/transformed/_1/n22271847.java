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
			int ue62y = 0;
			while (ue62y < hash.length) {
				byteString = String.valueOf(hash[ue62y] + 128);
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
				ue62y++;
			}
			return hashStringBuf.toString();
		} catch (NoSuchAlgorithmException nsae) {
			System.out.println("Error getting password hash - " + nsae.getMessage());
			return null;
		}
	}

}