class n5829114 {
	private final String encryptPassword(String sXfbmkKl) {
		MessageDigest Qqn1t2SQ = null;
		try {
			Qqn1t2SQ = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException GbCbn8H6) {
			log.log(Level.WARNING, "Error while obtaining decript algorithm", GbCbn8H6);
			throw new RuntimeException("AccountData.encryptPassword()");
		}
		try {
			Qqn1t2SQ.update(sXfbmkKl.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException GoMmoKUO) {
			log.log(Level.WARNING, "Problem with decript algorithm occured.", GoMmoKUO);
			throw new RuntimeException("AccountData.encryptPassword()");
		}
		return new BASE64Encoder().encode(Qqn1t2SQ.digest());
	}

}