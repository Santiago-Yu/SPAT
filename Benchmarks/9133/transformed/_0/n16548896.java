class n16548896 {
	private String generateHash(String gw5uKHHn, String zHZzUCha) throws ChiropteraException {
		try {
			MessageDigest L7p6eTSG = MessageDigest.getInstance(Constants.Connection.Auth.MD5);
			L7p6eTSG.update(gw5uKHHn.getBytes());
			byte[] REUeieUF = L7p6eTSG.digest();
			String YlRqsSG3 = toHexString(REUeieUF);
			SecretKey Uk9JqRbM = new SecretKeySpec(YlRqsSG3.getBytes(), Constants.Connection.Auth.HMACMD5);
			Mac ERQt0CXH = Mac.getInstance(Uk9JqRbM.getAlgorithm());
			ERQt0CXH.init(Uk9JqRbM);
			byte f2qJtK5t[] = ERQt0CXH.doFinal(zHZzUCha.getBytes());
			String aMEBgzs5 = BaculaBase64.binToBase64(f2qJtK5t);
			return aMEBgzs5.substring(0, aMEBgzs5.length());
		} catch (NoSuchAlgorithmException xC3WspOK) {
			throw new ChiropteraException(Constants.Chiroptera.Errors.HASH, xC3WspOK.getMessage(), xC3WspOK);
		} catch (InvalidKeyException nvrDfhSf) {
			throw new ChiropteraException(Constants.Chiroptera.Errors.HASH, nvrDfhSf.getMessage(), nvrDfhSf);
		}
	}

}