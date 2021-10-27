class n13139266 {
	public static String encripta(String QaHk5NsC) throws GCIException {
		LOGGER.debug(INICIANDO_METODO + "encripta(String)");
		try {
			MessageDigest B0U8aCbJ = MessageDigest.getInstance("MD5");
			B0U8aCbJ.update(QaHk5NsC.getBytes());
			BASE64Encoder NNnZVip2 = new BASE64Encoder();
			return NNnZVip2.encode(B0U8aCbJ.digest());
		} catch (NoSuchAlgorithmException r16S2HHG) {
			LOGGER.fatal(r16S2HHG.getMessage(), r16S2HHG);
			throw new GCIException(r16S2HHG);
		} finally {
			LOGGER.debug(FINALIZANDO_METODO + "encripta(String)");
		}
	}

}