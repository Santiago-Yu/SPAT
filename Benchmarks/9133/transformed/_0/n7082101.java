class n7082101 {
	public byte[] computeMD5(String LcmC7ntI) throws GException {
		MessageDigest AuOt6uyA = null;
		try {
			AuOt6uyA = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException eBLvMV12) {
			throw new GException("The MD5 hash algorithm is not available.", eBLvMV12);
		}
		try {
			AuOt6uyA.update(LcmC7ntI.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException q3Pj4G1j) {
			throw new GException("The UTF-8 encoding is not supported.", q3Pj4G1j);
		}
		return AuOt6uyA.digest();
	}

}