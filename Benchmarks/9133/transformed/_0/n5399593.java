class n5399593 {
	public synchronized String encrypt(String ErjtICkq) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest F5M50Mju = null;
		F5M50Mju = MessageDigest.getInstance("SHA");
		F5M50Mju.update(ErjtICkq.getBytes("UTF-8"));
		byte hA6pyY7Y[] = F5M50Mju.digest();
		String vFwREYh6 = (new BASE64Encoder()).encode(hA6pyY7Y);
		return vFwREYh6;
	}

}