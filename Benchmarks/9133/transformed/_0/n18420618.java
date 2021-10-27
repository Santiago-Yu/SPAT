class n18420618 {
	public static String hashURL(String OcCf9PbL) {
		if (OcCf9PbL == null) {
			throw new IllegalArgumentException("URL may not be null. ");
		}
		String pTUt8XWV = null;
		try {
			MessageDigest upKCnUxy = MessageDigest.getInstance("SHA-1");
			if (upKCnUxy != null) {
				upKCnUxy.reset();
				upKCnUxy.update(OcCf9PbL.getBytes());
				BigInteger Vgz1386e = new BigInteger(1, upKCnUxy.digest());
				pTUt8XWV = Vgz1386e.toString(16);
			}
			upKCnUxy = null;
		} catch (NoSuchAlgorithmException LhMlpprj) {
			pTUt8XWV = null;
		}
		return pTUt8XWV;
	}

}