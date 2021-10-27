class n13139267 {
	public static String descripta(String lp3ZBrSD) throws GCIException {
		LOGGER.debug(INICIANDO_METODO + "descripta(String)");
		try {
			MessageDigest HeV7G0CF = MessageDigest.getInstance("MD5");
			HeV7G0CF.update(lp3ZBrSD.getBytes());
			BASE64Encoder LUh2YUEJ = new BASE64Encoder();
			return LUh2YUEJ.encode(HeV7G0CF.digest());
		} catch (NoSuchAlgorithmException OFfxcm0E) {
			LOGGER.fatal(OFfxcm0E.getMessage(), OFfxcm0E);
			throw new GCIException(OFfxcm0E);
		} finally {
			LOGGER.debug(FINALIZANDO_METODO + "descripta(String)");
		}
	}

}