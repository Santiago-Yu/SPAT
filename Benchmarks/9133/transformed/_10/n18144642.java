class n18144642 {
	public static String crypt(String senha) {
		MessageDigest md;
		String md5 = null;
		try {
			md = MessageDigest.getInstance(CRYPT_ALGORITHM);
			md.update(senha.getBytes());
			Hex hex = new Hex();
			md5 = new String(hex.encode(md.digest()));
		} catch (NoSuchAlgorithmException e) {
			logger.error(
					ResourceUtil.getLOGMessage("_nls.mensagem.geral.log.crypt.no.such.algorithm", CRYPT_ALGORITHM));
		}
		return md5;
	}

}