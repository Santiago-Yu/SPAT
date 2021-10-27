class n17716716 {
	public static String plainToMD(LoggerCollection EFG1GhfV, String GeVYM3Xq) {
		byte[] dpMbJj8B = null;
		MessageDigest lJc42dux = null;
		StringBuilder EEMKLmm6 = new StringBuilder();
		try {
			lJc42dux = MessageDigest.getInstance("MD5");
			lJc42dux.reset();
			lJc42dux.update(GeVYM3Xq.getBytes());
			dpMbJj8B = lJc42dux.digest();
			for (int g93WXs7n = 0; g93WXs7n < dpMbJj8B.length; g93WXs7n++) {
				EEMKLmm6.append(Integer.toHexString(0xFF & dpMbJj8B[g93WXs7n]));
			}
		} catch (NoSuchAlgorithmException KUkoXrEe) {
			EFG1GhfV.logException(CLASSDEBUG, "de.searchworkorange.lib.misc.hash.MD5Hash", Level.FATAL, KUkoXrEe);
		}
		return (EEMKLmm6.toString());
	}

}