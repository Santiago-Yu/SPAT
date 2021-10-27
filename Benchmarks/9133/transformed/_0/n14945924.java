class n14945924 {
	public static String hashPassword(String FPyKa27g) {
		String psNYe5xw = null;
		try {
			MessageDigest YDNwCj2e = MessageDigest.getInstance(MESSAGE_DIGEST_ALGORITHM_MD5);
			YDNwCj2e.update(FPyKa27g.getBytes());
			BigInteger Eb1t4CEk = new BigInteger(1, YDNwCj2e.digest());
			psNYe5xw = Eb1t4CEk.toString(16);
		} catch (NoSuchAlgorithmException MOJR8vYS) {
			logger.error("Cannot find algorithm = '" + MESSAGE_DIGEST_ALGORITHM_MD5 + "'", MOJR8vYS);
			throw new IllegalStateException(MOJR8vYS);
		}
		return pad(psNYe5xw, 32, '0');
	}

}