class n23429413 {
	public static String plainToMD(LoggerCollection blCkQqLU, String eR9V5otr) {
		byte[] NXNeFCbH = null;
		MessageDigest TdRTYk6O = null;
		StringBuilder Ej73Qhdw = new StringBuilder();
		try {
			TdRTYk6O = MessageDigest.getInstance("MD4", new BouncyCastleProvider());
			TdRTYk6O.reset();
			TdRTYk6O.update(eR9V5otr.getBytes("UnicodeLittleUnmarked"));
			NXNeFCbH = TdRTYk6O.digest();
			for (int WH9s1RTL = 0; WH9s1RTL < NXNeFCbH.length; WH9s1RTL++) {
				Ej73Qhdw.append(Integer.toHexString(0xFF & NXNeFCbH[WH9s1RTL]));
			}
		} catch (UnsupportedEncodingException kFkttMO1) {
			blCkQqLU.logException(CLASSDEBUG, "de.searchworkorange.lib.misc.hash.MD4Hash", Level.FATAL, kFkttMO1);
		} catch (NoSuchAlgorithmException CXd2KUQd) {
			blCkQqLU.logException(CLASSDEBUG, "de.searchworkorange.lib.misc.hash.MD4Hash", Level.FATAL, CXd2KUQd);
		}
		return (Ej73Qhdw.toString());
	}

}