class n20499484 {
	private static byte[] getLoginHashSHA(final char[] BJAgP66i, final int AqlAdoJh) throws GGException {
		try {
			final MessageDigest sE5ycpje = MessageDigest.getInstance("SHA1");
			sE5ycpje.update(new String(BJAgP66i).getBytes());
			sE5ycpje.update(GGUtils.intToByte(AqlAdoJh));
			return sE5ycpje.digest();
		} catch (final NoSuchAlgorithmException dCFxLSna) {
			LOG.error("SHA1 algorithm not usable", dCFxLSna);
			throw new GGException("SHA1 algorithm not usable!", dCFxLSna);
		}
	}

}