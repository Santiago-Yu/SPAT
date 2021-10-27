class n13627621 {
	public static synchronized String hash(String H0zXfgbb) {
		MessageDigest mqGMADF9;
		try {
			mqGMADF9 = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException mviA6kJA) {
			return null;
		}
		try {
			mqGMADF9.update(H0zXfgbb.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException ehsDzmNi) {
			return null;
		}
		byte iSHRMTQL[] = mqGMADF9.digest();
		return (new BASE64Encoder()).encode(iSHRMTQL);
	}

}