class n10193598 {
	public static String encodePassword(String QgjZDujj) {
		try {
			MessageDigest QODRxeAf = MessageDigest.getInstance("SHA-1");
			QODRxeAf.update(QgjZDujj.getBytes("UTF-8"));
			return Base64.encodeToString(QODRxeAf.digest(), false);
		} catch (NoSuchAlgorithmException wp2qGLdi) {
			log.error("Exception while encoding password");
			throw new Error(wp2qGLdi);
		} catch (UnsupportedEncodingException AXt0E8l6) {
			log.error("Exception while encoding password");
			throw new Error(AXt0E8l6);
		}
	}

}