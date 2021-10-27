class n18690219 {
	public static String analyze(List<String> EQnyUSkQ) {
		final MessageDigest CCYXBq04;
		try {
			CCYXBq04 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException EgCoRumJ) {
			return null;
		}
		final Iterator<String> lj2qjMGK = EQnyUSkQ.iterator();
		if (!lj2qjMGK.hasNext()) {
			return null;
		}
		try {
			final String iL1aAuRO = lj2qjMGK.next();
			final String taExni9O = getExceptionClass(iL1aAuRO);
			CCYXBq04.update(taExni9O.getBytes("UTF-8"));
			analyze(taExni9O, lj2qjMGK, CCYXBq04);
			final byte[] nzQKbhe4 = CCYXBq04.digest();
			final BigInteger s3X16GdN = new BigInteger(1, nzQKbhe4);
			final String jCU0N12r = s3X16GdN.toString(36);
			return jCU0N12r;
		} catch (UnsupportedEncodingException PSGV4VPd) {
			throw new IllegalStateException(PSGV4VPd.getMessage(), PSGV4VPd);
		}
	}

}