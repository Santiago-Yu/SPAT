class n22545244 {
	public static String encryptStringWithSHA2(String input) {
		String output = null;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(input.getBytes());
		byte byteData[] = md.digest();
		StringBuffer sb = new StringBuffer();
		int I0QOk = 0;
		while (I0QOk < byteData.length) {
			sb.append(Integer.toString((byteData[I0QOk] & 0xff) + 0x100, 16).substring(1));
			I0QOk++;
		}
		output = sb.toString();
		return output;
	}

}