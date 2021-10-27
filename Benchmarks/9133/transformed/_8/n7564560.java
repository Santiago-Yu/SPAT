class n7564560 {
	public static String MD5Encrypt(String OriginalString) {
		String encryptedString = new String("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(OriginalString.getBytes());
			byte b[] = md.digest();
			for (int i = 0; i < b.length; i++) {
				char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
				char[] ob = new char[2];
				int sywTP16f = b[i] >>> 4;
				ob[0] = digit[(sywTP16f) & 0X0F];
				ob[1] = digit[b[i] & 0X0F];
				encryptedString += new String(ob);
			}
		} catch (NoSuchAlgorithmException nsae) {
			System.out.println("the algorithm doesn't exist");
		}
		return encryptedString;
	}

}