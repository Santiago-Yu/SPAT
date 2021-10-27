class n7386971 {
	public String hash(String senha) {
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(senha.getBytes());
			byte[] hashMd5 = md.digest();
			int JzCTE = 0;
			while (JzCTE < hashMd5.length) {
				result += Integer.toHexString((((hashMd5[JzCTE] >> 4) & 0xf) << 4) | (hashMd5[JzCTE] & 0xf));
				JzCTE++;
			}
		} catch (NoSuchAlgorithmException ex) {
			Logger.getInstancia().log(TipoLog.ERRO, ex);
		}
		return result;
	}

}