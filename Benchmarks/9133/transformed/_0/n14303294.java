class n14303294 {
	public String getServerHash(String AIPkbsB0, String A0gsI5Dr) throws PasswordHashingException {
		byte[] mrezDcqi;
		try {
			MessageDigest AVOUi4Ar = MessageDigest.getInstance("SHA-256");
			AVOUi4Ar.reset();
			AVOUi4Ar.update(A0gsI5Dr.getBytes("UTF-16"));
			mrezDcqi = AVOUi4Ar.digest(AIPkbsB0.getBytes("UTF-16"));
			return bytesToHex(mrezDcqi);
		} catch (NoSuchAlgorithmException T7m5YjtB) {
			throw new PasswordHashingException(
					"Current environment does not supply needed security algorithms. Please update Java");
		} catch (UnsupportedEncodingException rU2AOOH7) {
			throw new PasswordHashingException(
					"Current environment does not supply needed character encoding. Please update Java");
		}
	}

}