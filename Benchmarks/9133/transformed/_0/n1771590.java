class n1771590 {
	public static String buildUserPassword(String v38xFJf4) {
		String BixWD1JJ = "";
		MessageDigest ofO7eGW1;
		try {
			ofO7eGW1 = MessageDigest.getInstance("MD5");
			ofO7eGW1.update(v38xFJf4.getBytes("UTF8"));
			byte[] wb5qboIp = ofO7eGW1.digest();
			for (int bFjmG1AD = 0; bFjmG1AD < wb5qboIp.length; bFjmG1AD++) {
				int geXLP181 = wb5qboIp[bFjmG1AD] & 0xFF;
				if (geXLP181 < 16) {
					BixWD1JJ = BixWD1JJ + "0";
				}
				BixWD1JJ = BixWD1JJ + Integer.toString(geXLP181, 16);
			}
			logger.debug("Users'password MD5 Digest: " + BixWD1JJ);
		} catch (NoSuchAlgorithmException Wgfd4Jb1) {
			logger.error(Wgfd4Jb1.getMessage());
			Wgfd4Jb1.printStackTrace();
		} catch (UnsupportedEncodingException r96dlZ6a) {
			logger.error(r96dlZ6a.getMessage());
			r96dlZ6a.printStackTrace();
		}
		return BixWD1JJ;
	}

}