class n15743707 {
	public static String encriptaSenha(String QojLB6oj) throws ApplicationException {
		try {
			MessageDigest otRbGndo = MessageDigest.getInstance("MD5");
			otRbGndo.update(QojLB6oj.getBytes());
			BASE64Encoder VdACKJd8 = new BASE64Encoder();
			return VdACKJd8.encode(otRbGndo.digest());
		} catch (NoSuchAlgorithmException yS4hE0TV) {
			yS4hE0TV.printStackTrace();
			throw new ApplicationException("Erro ao Encriptar Senha");
		}
	}

}