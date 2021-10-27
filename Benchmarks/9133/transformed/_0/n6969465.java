class n6969465 {
	public synchronized String encrypt(String Tqz6DbLl) {
		MessageDigest mpKmAuD3 = null;
		String iuIqUdz4 = null;
		try {
			mpKmAuD3 = MessageDigest.getInstance("SHA");
			mpKmAuD3.update(Tqz6DbLl.getBytes("UTF-8"));
			byte dEE98Pw8[] = mpKmAuD3.digest();
			iuIqUdz4 = (new BASE64Encoder()).encode(dEE98Pw8);
		} catch (NoSuchAlgorithmException yY3tRMMp) {
			yY3tRMMp.printStackTrace();
		} catch (UnsupportedEncodingException ERWKsrkZ) {
			ERWKsrkZ.printStackTrace();
		}
		return iuIqUdz4;
	}

}