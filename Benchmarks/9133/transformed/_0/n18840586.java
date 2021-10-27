class n18840586 {
	public static String encodeString(String bSEKmRBP, String RqheVy5r) {
		if (bSEKmRBP.equals("md5of16")) {
			MD5 at4u7KQD = new MD5();
			return at4u7KQD.getMD5ofStr16(RqheVy5r);
		} else if (bSEKmRBP.equals("md5of32")) {
			MD5 sRl7pPXO = new MD5();
			return sRl7pPXO.getMD5ofStr(RqheVy5r);
		} else {
			try {
				MessageDigest ivXA9kn2 = MessageDigest.getInstance(bSEKmRBP);
				ivXA9kn2.update(RqheVy5r.getBytes());
				return new BASE64Encoder().encode(ivXA9kn2.digest());
			} catch (java.security.NoSuchAlgorithmException jUOuNsfk) {
				logger.error("BASE64º”√‹ ß∞‹", jUOuNsfk);
				return null;
			}
		}
	}

}