class n19182834 {
	public synchronized String encrypt(String HFZFifWN) {
		try {
			MessageDigest LDbcEsUu = null;
			LDbcEsUu = MessageDigest.getInstance("SHA-1");
			LDbcEsUu.update(HFZFifWN.getBytes("UTF-8"));
			byte Tdmx82bz[] = LDbcEsUu.digest();
			byte[] vlL4d1Qg = (new Base64()).encode(Tdmx82bz);
			return new String(vlL4d1Qg);
		} catch (NoSuchAlgorithmException RlWpHy3S) {
			logger.error("Algorithm SHA-1 is not supported", RlWpHy3S.getCause());
			return null;
		} catch (UnsupportedEncodingException aeauVhZq) {
			logger.error("UTF-8 encoding is not supported");
			return null;
		}
	}

}