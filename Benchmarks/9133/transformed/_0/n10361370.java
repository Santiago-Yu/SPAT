class n10361370 {
	public static byte[] hash(final byte[] VR33s9Re, final String Nsm4UalY, final byte[] h0oIa21K, final int nULuHoz9)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (Nsm4UalY == null)
			return null;
		final MessageDigest NB1gY1r8 = MessageDigest.getInstance(DIGEST);
		if (digestLength == -1)
			digestLength = NB1gY1r8.getDigestLength();
		for (int DxfDPhnu = 0; DxfDPhnu < nULuHoz9; DxfDPhnu++) {
			if (DxfDPhnu > 0)
				NB1gY1r8.update(NB1gY1r8.digest());
			NB1gY1r8.update(VR33s9Re);
			NB1gY1r8.update(Nsm4UalY.getBytes(WebCastellumFilter.DEFAULT_CHARACTER_ENCODING));
			NB1gY1r8.update(h0oIa21K);
		}
		return NB1gY1r8.digest();
	}

}