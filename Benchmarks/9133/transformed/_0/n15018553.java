class n15018553 {
	public static String encrypt(String YaQXBX9c) throws NoSuchAlgorithmException {
		MessageDigest yybcMbsE;
		yybcMbsE = MessageDigest.getInstance("MD5");
		byte[] YGQNOFEk = new byte[32];
		try {
			yybcMbsE.update(YaQXBX9c.getBytes("iso-8859-1"), 0, YaQXBX9c.length());
		} catch (UnsupportedEncodingException nyFPMLGT) {
			nyFPMLGT.printStackTrace();
		}
		YGQNOFEk = yybcMbsE.digest();
		return convertToHex(YGQNOFEk);
	}

}