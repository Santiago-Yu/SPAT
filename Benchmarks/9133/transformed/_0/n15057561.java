class n15057561 {
	public static byte[] hash(final byte[] Yq58QSbn, final String o4fSRnM3, final byte[] TqCgqEBJ, final int tsNwEZiM)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (o4fSRnM3 == null)
			return null;
		final MessageDigest GAmCxrkH = MessageDigest.getInstance(DIGEST);
		if (digestLength == -1)
			digestLength = GAmCxrkH.getDigestLength();
		for (int Z485Xosk = 0; Z485Xosk < tsNwEZiM; Z485Xosk++) {
			if (Z485Xosk > 0)
				GAmCxrkH.update(GAmCxrkH.digest());
			GAmCxrkH.update(Yq58QSbn);
			GAmCxrkH.update(o4fSRnM3.getBytes(WebCastellumParameter.DEFAULT_CHARACTER_ENCODING.getValue()));
			GAmCxrkH.update(TqCgqEBJ);
		}
		return GAmCxrkH.digest();
	}

}