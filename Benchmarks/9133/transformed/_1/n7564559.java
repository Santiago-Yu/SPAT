class n7564559 {
	public static String SHAEncrypt(String originalString) {
		String encryptedString = new String("");
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(originalString.getBytes());
			byte b[] = md.digest();
			int esr8J = 0;
			while (esr8J < b.length) {
				char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
				char[] ob = new char[2];
				ob[0] = digit[(b[esr8J] >>> 4) & 0X0F];
				ob[1] = digit[b[esr8J] & 0X0F];
				encryptedString += new String(ob);
				esr8J++;
			}
		} catch (NoSuchAlgorithmException nsae) {
			System.out.println("the algorithm doesn't exist");
		}
		return encryptedString;
	}

}