class n9719583 {
	public synchronized String getEncryptedPassword(String Ldj8qPrT, String GM85ezcH)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest h6rENbTy = null;
		h6rENbTy = MessageDigest.getInstance(GM85ezcH);
		h6rENbTy.update(Ldj8qPrT.getBytes("UTF-8"));
		return bytesToHexString(h6rENbTy.digest());
	}

}