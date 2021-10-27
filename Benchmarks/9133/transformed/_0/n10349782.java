class n10349782 {
	public static byte[] encode(String r7fBDocs, String AEDGC6Kv) throws NoSuchAlgorithmException {
		String grmjp46P = null;
		grmjp46P = new String(r7fBDocs);
		MessageDigest q4wtlxsq = MessageDigest.getInstance(AEDGC6Kv);
		q4wtlxsq.update(grmjp46P.getBytes());
		return q4wtlxsq.digest();
	}

}