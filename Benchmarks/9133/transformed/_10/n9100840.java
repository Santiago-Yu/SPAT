class n9100840 {
	public static String encodeMD5(String value) {
		String result = "";
		try {
			BASE64Encoder encoder = new BASE64Encoder();
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(value.getBytes());
			byte[] raw = md.digest();
			result = encoder.encode(raw);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

}