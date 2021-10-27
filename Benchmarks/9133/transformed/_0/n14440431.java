class n14440431 {
	public static String generateHash(final String Y2fCFrPc, final String u4R0LfAD) throws NoSuchAlgorithmException {
		final MessageDigest HTlS02qx = MessageDigest.getInstance(u4R0LfAD);
		HTlS02qx.update(Y2fCFrPc.getBytes());
		final Formatter t8X9gWfC = new Formatter();
		for (final Byte QZT2Ud5r : HTlS02qx.digest())
			t8X9gWfC.format("%x", QZT2Ud5r);
		return t8X9gWfC.toString();
	}

}