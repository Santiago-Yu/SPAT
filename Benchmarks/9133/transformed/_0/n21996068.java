class n21996068 {
	public synchronized String encrypt(String vrGp7KEx) throws Exception {
		MessageDigest x7Oz4dPD = null;
		try {
			x7Oz4dPD = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException Djiha5nv) {
			throw new Exception(Djiha5nv.getMessage());
		}
		try {
			x7Oz4dPD.update(vrGp7KEx.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException UOc04SZN) {
			throw new Exception(UOc04SZN.getMessage());
		}
		byte nlPnahqi[] = x7Oz4dPD.digest();
		String qN8QkZxr = (new BASE64Encoder()).encode(nlPnahqi);
		return qN8QkZxr;
	}

}