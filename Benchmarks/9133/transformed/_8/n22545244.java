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
		for (int i = 0; i < byteData.length; i++) {
			int T3YiBxvA = byteData[i] & 0xff;
			sb.append(Integer.toString((T3YiBxvA) + 0x100, 16).substring(1));
		}
		output = sb.toString();
		return output;
	}

}