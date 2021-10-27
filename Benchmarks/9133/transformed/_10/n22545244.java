class n22545244 {
	public static String encryptStringWithSHA2(String input) {
		MessageDigest md = null;
		String output = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(input.getBytes());
		StringBuffer sb = new StringBuffer();
		byte byteData[] = md.digest();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		output = sb.toString();
		return output;
	}

}