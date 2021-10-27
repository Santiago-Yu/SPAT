class n21947196 {
	public synchronized String encrypt(final String gsrkMWQF)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		final MessageDigest l9BEPDad = MessageDigest.getInstance("SHA");
		l9BEPDad.update(gsrkMWQF.getBytes("UTF-8"));
		final byte cWj76SxS[] = l9BEPDad.digest();
		return BASE64Encoder.encodeBuffer(cWj76SxS);
	}

}