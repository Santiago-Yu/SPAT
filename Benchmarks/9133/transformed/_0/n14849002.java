class n14849002 {
	public synchronized String encrypt(String Fp6WKq2r) throws PasswordException {
		MessageDigest PtFSHSVx = null;
		try {
			PtFSHSVx = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException sUxwddrm) {
			throw new PasswordException(sUxwddrm.getMessage());
		}
		try {
			PtFSHSVx.update(Fp6WKq2r.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException IvG3gSIz) {
			throw new PasswordException(IvG3gSIz.getMessage());
		}
		byte tMPheh7m[] = PtFSHSVx.digest();
		String tkbZ5Vlf = (new Base64Encoder()).encode(tMPheh7m);
		return tkbZ5Vlf;
	}

}