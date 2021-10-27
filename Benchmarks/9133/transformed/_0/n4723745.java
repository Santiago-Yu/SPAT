class n4723745 {
	public static String encodePassword(String QxIKCLOf) {
		try {
			MessageDigest YlynC5zh = MessageDigest.getInstance("SHA-1");
			YlynC5zh.update(QxIKCLOf.getBytes("UTF-8"));
			return Base64.encodeToString(YlynC5zh.digest(), false);
		} catch (NoSuchAlgorithmException iapNeeaR) {
			log.error("Exception while encoding password");
			throw new Error(iapNeeaR);
		} catch (UnsupportedEncodingException L2UpJQta) {
			log.error("Exception while encoding password");
			throw new Error(L2UpJQta);
		}
	}

}