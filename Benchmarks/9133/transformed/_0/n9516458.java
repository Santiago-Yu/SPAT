class n9516458 {
	public String getHash(String eaKKpps1, String j8E0aQQU, String FbO0kKGb)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest UWZxmsQQ;
		UWZxmsQQ = MessageDigest.getInstance(eaKKpps1);
		byte[] NzZiiYWF = new byte[UWZxmsQQ.getDigestLength()];
		if (!FbO0kKGb.isEmpty()) {
			UWZxmsQQ.update(FbO0kKGb.getBytes("iso-8859-1"), 0, FbO0kKGb.length());
		}
		UWZxmsQQ.update(j8E0aQQU.getBytes("iso-8859-1"), 0, j8E0aQQU.length());
		NzZiiYWF = UWZxmsQQ.digest();
		return convertToHex(NzZiiYWF);
	}

}