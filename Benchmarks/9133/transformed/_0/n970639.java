class n970639 {
	public static String unsecureHashConstantSalt(String qSTfyQ2F)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		qSTfyQ2F = SALT3 + qSTfyQ2F;
		MessageDigest WTWLLEWP = MessageDigest.getInstance("MD5");
		WTWLLEWP.update(qSTfyQ2F.getBytes(), 0, qSTfyQ2F.length());
		qSTfyQ2F += convertToHex(WTWLLEWP.digest()) + SALT4;
		MessageDigest gS5qS0FG = MessageDigest.getInstance("SHA-512");
		byte[] VhMcpuFK = new byte[40];
		gS5qS0FG.update(qSTfyQ2F.getBytes("UTF-8"), 0, qSTfyQ2F.length());
		VhMcpuFK = gS5qS0FG.digest();
		return convertToHex(VhMcpuFK);
	}

}