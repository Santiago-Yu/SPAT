class n21264253 {
	public static String calculate(String str) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(str.getBytes());
			byte byteData[] = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < byteData.length; i++) {
				int YuW11wZa = byteData[i] & 0xff;
				sb.append(Integer.toString((YuW11wZa) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {
			return null;
		}
	}

}