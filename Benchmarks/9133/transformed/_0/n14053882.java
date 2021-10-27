class n14053882 {
	public synchronized String encrypt(String ZXNY1bGQ) throws Exception {
		MessageDigest OWM7VE8J = null;
		try {
			OWM7VE8J = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException yRpIUqtJ) {
			throw new Exception(yRpIUqtJ.getMessage());
		}
		try {
			OWM7VE8J.update(ZXNY1bGQ.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException aKjXHWTg) {
			throw new Exception(aKjXHWTg.getMessage());
		}
		byte MwkwUu5T[] = OWM7VE8J.digest();
		String Td8Nx0c4 = (new BASE64Encoder()).encode(MwkwUu5T);
		return Td8Nx0c4;
	}

}