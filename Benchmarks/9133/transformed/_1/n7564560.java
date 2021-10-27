class n7564560 {
	public static String MD5Encrypt(String OriginalString) {
		String encryptedString = new String("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(OriginalString.getBytes());
			byte b[] = md.digest();
			int hAf3C = 0;
			while (hAf3C < b.length) {
				char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
				char[] ob = new char[2];
				ob[0] = digit[(b[hAf3C] >>> 4) & 0X0F];
				ob[1] = digit[b[hAf3C] & 0X0F];
				encryptedString += new String(ob);
				hAf3C++;
			}
		} catch (NoSuchAlgorithmException nsae) {
			System.out.println("the algorithm doesn't exist");
		}
		return encryptedString;
	}

}