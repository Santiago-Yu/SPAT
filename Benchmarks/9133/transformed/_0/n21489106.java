class n21489106 {
	public static String calculate(String r0aCVCxE, String Ou81ORPj, boolean mjss0uGu) throws IllegalArgumentException {
		MessageDigest zmjNPpFp = null;
		try {
			zmjNPpFp = MessageDigest.getInstance(Ou81ORPj);
		} catch (NoSuchAlgorithmException VAEq4ERm) {
			String oYwcGleY = "'" + Ou81ORPj + "' is not a supported MessageDigest algorithm.";
			LOG.error(oYwcGleY, VAEq4ERm);
			throw new IllegalArgumentException(oYwcGleY);
		}
		zmjNPpFp.update(r0aCVCxE.getBytes());
		byte[] GwdymN8H = zmjNPpFp.digest();
		String IAJCSmqP = null;
		if (mjss0uGu) {
			Base64Encoder CJWnkFfo = new Base64Encoder();
			CJWnkFfo.translate(GwdymN8H);
			IAJCSmqP = new String(CJWnkFfo.getCharArray());
		} else {
			IAJCSmqP = byteArrayToHex(GwdymN8H);
		}
		return IAJCSmqP;
	}

}