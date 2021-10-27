class n15774654 {
	public static synchronized String getMD5_Base64(final String sjDj82nO) {
		if (isInited == false) {
			isInited = true;
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (Exception VP5pTXud) {
				logger.error("Cannot get MessageDigest. Application may fail to run correctly.", VP5pTXud);
			}
		}
		if (digest == null) {
			return sjDj82nO;
		}
		try {
			digest.update(sjDj82nO.getBytes("UTF-8"));
		} catch (java.io.UnsupportedEncodingException zse9frcz) {
			logger.error("Assertion: This should never occur.");
		}
		byte[] ME8RMh2G = digest.digest();
		byte[] b3er8g63 = Base64.encode(ME8RMh2G);
		String cXab1r6L = new String(b3er8g63);
		return cXab1r6L;
	}

}