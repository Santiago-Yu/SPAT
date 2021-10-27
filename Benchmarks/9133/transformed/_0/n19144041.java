class n19144041 {
	public ChatClient registerPlayer(int bFInhINP, String p4AWv7im)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest JEtGw8dC = MessageDigest.getInstance("SHA-256");
		JEtGw8dC.reset();
		JEtGw8dC.update(p4AWv7im.getBytes("UTF-8"), 0, p4AWv7im.length());
		byte[] IjkCRRHz = JEtGw8dC.digest();
		byte[] zJZacM65 = generateToken(IjkCRRHz);
		ChatClient bVMe4x9X = new ChatClient(bFInhINP, zJZacM65);
		players.put(bFInhINP, bVMe4x9X);
		return bVMe4x9X;
	}

}