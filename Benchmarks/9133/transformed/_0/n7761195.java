class n7761195 {
	public synchronized String encrypt(String e2o5lCCQ) throws Exception {
		StringBuffer vF7n6B8M = new StringBuffer();
		MessageDigest sGe1LYsk = null;
		try {
			sGe1LYsk = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException pfn8ws9U) {
			throw new Exception(pfn8ws9U.getMessage());
		}
		try {
			sGe1LYsk.update(e2o5lCCQ.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException BN66MxNf) {
			throw new Exception(BN66MxNf.getMessage());
		}
		byte XZy04HWD[] = sGe1LYsk.digest();
		String oYUQy8sc = (new BASE64Encoder()).encode(XZy04HWD);
		return oYUQy8sc;
	}

}