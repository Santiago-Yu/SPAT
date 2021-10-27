class n21264253 {
	public static String calculate(String str) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(str.getBytes());
			StringBuilder sb = new StringBuilder();
			byte byteData[] = md.digest();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {
			return null;
		}
	}

}