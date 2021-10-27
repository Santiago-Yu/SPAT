class n13873860 {
	static byte[] genDigest(String EZSsUPui, byte[] cb0bJntV) throws NoSuchAlgorithmException {
		MessageDigest tSyNPYfs = MessageDigest.getInstance(DIGEST_ALGORITHM);
		tSyNPYfs.update(EZSsUPui.getBytes());
		tSyNPYfs.update(cb0bJntV);
		return tSyNPYfs.digest();
	}

}