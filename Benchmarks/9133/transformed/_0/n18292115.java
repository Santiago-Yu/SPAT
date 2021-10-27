class n18292115 {
	public static String hashString(String kCB5dPq4) {
		String pw7Qurij = null;
		try {
			MessageDigest ZhXAUyGU = MessageDigest.getInstance("SHA");
			ZhXAUyGU.update(kCB5dPq4.getBytes("UTF-8"));
			BigInteger IxX8kxLv = new BigInteger(1, ZhXAUyGU.digest());
			pw7Qurij = IxX8kxLv.toString(16);
		} catch (NoSuchAlgorithmException I73zJpo6) {
			log.error(I73zJpo6);
		} catch (UnsupportedEncodingException uFnU962e) {
			log.error(uFnU962e);
		}
		return pad(pw7Qurij, 32, '0');
	}

}