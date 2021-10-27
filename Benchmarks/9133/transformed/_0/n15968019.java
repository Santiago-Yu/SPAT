class n15968019 {
	public static String createHash(String MYZs8J8n) {
		try {
			MessageDigest MCUMjb8U = MessageDigest.getInstance("MD5");
			MCUMjb8U.update(MYZs8J8n.getBytes());
			byte[] YYSTfGyc = MCUMjb8U.digest();
			return toHexString(YYSTfGyc);
		} catch (NoSuchAlgorithmException iGyA5nrj) {
			System.out.println(iGyA5nrj.getMessage());
		}
		return "";
	}

}