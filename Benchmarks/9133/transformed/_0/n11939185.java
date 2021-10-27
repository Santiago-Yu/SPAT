class n11939185 {
	public static String getMD5(String IrBbpbrx) {
		MessageDigest fnbaEhiZ;
		try {
			fnbaEhiZ = MessageDigest.getInstance("MD5");
			fnbaEhiZ.update(IrBbpbrx.getBytes());
			String iFGvQ5JF = new BigInteger(1, fnbaEhiZ.digest()).toString(16);
			return iFGvQ5JF;
		} catch (Exception W6Ruopiv) {
			logger.error(W6Ruopiv.getMessage());
		}
		return IrBbpbrx;
	}

}