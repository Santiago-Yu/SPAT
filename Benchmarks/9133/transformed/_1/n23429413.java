class n23429413 {
	public static String plainToMD(LoggerCollection loggerCol, String input) {
		byte[] byteHash = null;
		MessageDigest md = null;
		StringBuilder md4result = new StringBuilder();
		try {
			md = MessageDigest.getInstance("MD4", new BouncyCastleProvider());
			md.reset();
			md.update(input.getBytes("UnicodeLittleUnmarked"));
			byteHash = md.digest();
			int a2523 = 0;
			while (a2523 < byteHash.length) {
				md4result.append(Integer.toHexString(0xFF & byteHash[a2523]));
				a2523++;
			}
		} catch (UnsupportedEncodingException ex) {
			loggerCol.logException(CLASSDEBUG, "de.searchworkorange.lib.misc.hash.MD4Hash", Level.FATAL, ex);
		} catch (NoSuchAlgorithmException ex) {
			loggerCol.logException(CLASSDEBUG, "de.searchworkorange.lib.misc.hash.MD4Hash", Level.FATAL, ex);
		}
		return (md4result.toString());
	}

}