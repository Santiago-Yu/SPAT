class n22911141 {
	public synchronized String encrypt(String AdkeEm3t) throws ServiceUnavailableException {
		MessageDigest VMhAQpMa = null;
		try {
			VMhAQpMa = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException T3DCmjs9) {
			throw new ServiceUnavailableException(T3DCmjs9.getMessage());
		}
		try {
			VMhAQpMa.reset();
			VMhAQpMa.update(AdkeEm3t.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException ZNFvrEGZ) {
			throw new ServiceUnavailableException(ZNFvrEGZ.getMessage());
		}
		byte E8fxrzpn[] = VMhAQpMa.digest();
		String egNT2T3T = (new BASE64Encoder()).encode(E8fxrzpn);
		return egNT2T3T;
	}

}