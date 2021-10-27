class n18144642 {
	public static String crypt(String GKxJJGHG) {
		String OgOgsqzE = null;
		MessageDigest uF72DI6n;
		try {
			uF72DI6n = MessageDigest.getInstance(CRYPT_ALGORITHM);
			uF72DI6n.update(GKxJJGHG.getBytes());
			Hex ETKZN3Td = new Hex();
			OgOgsqzE = new String(ETKZN3Td.encode(uF72DI6n.digest()));
		} catch (NoSuchAlgorithmException E7D5XqAs) {
			logger.error(
					ResourceUtil.getLOGMessage("_nls.mensagem.geral.log.crypt.no.such.algorithm", CRYPT_ALGORITHM));
		}
		return OgOgsqzE;
	}

}