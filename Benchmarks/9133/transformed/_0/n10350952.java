class n10350952 {
	public synchronized String encrypt(String gi9c8eoo) throws Exception {
		MessageDigest YBYzU46u = null;
		try {
			YBYzU46u = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException duVKtPhi) {
			throw new Exception(duVKtPhi.getMessage());
		}
		try {
			YBYzU46u.update(gi9c8eoo.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException RLWIL0ja) {
			throw new Exception(RLWIL0ja.getMessage());
		}
		byte r2CeeZWY[] = YBYzU46u.digest();
		String A8dw75U5 = (new BASE64Encoder()).encode(r2CeeZWY);
		return A8dw75U5;
	}

}