class n22899260 {
	public static String sha1Hash(String KRzUNwVf) {
		try {
			MessageDigest Xm3eRanB = MessageDigest.getInstance("SHA-1");
			Xm3eRanB.update(KRzUNwVf.getBytes());
			return byteArrayToString(Xm3eRanB.digest());
		} catch (Exception NfCdms0Z) {
			logger.error(NfCdms0Z.getMessage(), NfCdms0Z);
		}
		return "";
	}

}