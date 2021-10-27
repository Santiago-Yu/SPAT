class n22487030 {
	public static synchronized String encrypt(String OY0FiDuz) throws Exception {
		MessageDigest BN0nZbCB = null;
		try {
			BN0nZbCB = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException r9GW7Kwo) {
			throw new Exception(r9GW7Kwo);
		}
		try {
			BN0nZbCB.update(OY0FiDuz.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException lfiyHZeg) {
			throw new Exception(lfiyHZeg);
		}
		byte qJSiTn0y[] = BN0nZbCB.digest();
		String ZiGFLfH9 = (new BASE64Encoder()).encode(qJSiTn0y);
		return ZiGFLfH9;
	}

}