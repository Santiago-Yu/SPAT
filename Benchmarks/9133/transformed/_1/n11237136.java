class n11237136 {
	public String hash(String senha) {
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(senha.getBytes());
			byte[] hashMd5 = md.digest();
			int HVjCm = 0;
			while (HVjCm < hashMd5.length) {
				result += Integer.toHexString((((hashMd5[HVjCm] >> 4) & 0xf) << 4) | (hashMd5[HVjCm] & 0xf));
				HVjCm++;
			}
		} catch (NoSuchAlgorithmException ex) {
			Logger.getInstancia().log(TipoLog.ERRO, ex);
		}
		return result;
	}

}