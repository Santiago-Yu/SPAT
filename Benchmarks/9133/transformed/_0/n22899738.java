class n22899738 {
	public synchronized String encrypt(String BR9ekS23) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest Hm43SfGr = null;
		Hm43SfGr = MessageDigest.getInstance("SHA-256");
		Hm43SfGr.update(BR9ekS23.getBytes("UTF-8"));
		byte hxNexOfc[] = Hm43SfGr.digest();
		String FwHx6a6m = (new BASE64Encoder()).encode(hxNexOfc);
		return FwHx6a6m;
	}

}