class n12937087 {
	public ChatClient registerPlayer(int yL1U3kXC, String Pe0lNodp)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest y4U5dlzK = MessageDigest.getInstance("SHA-256");
		y4U5dlzK.reset();
		y4U5dlzK.update(Pe0lNodp.getBytes("UTF-8"), 0, Pe0lNodp.length());
		byte[] SEXNGMYH = y4U5dlzK.digest();
		byte[] JLzDJTVE = generateToken(SEXNGMYH);
		ChatClient A2NgwUD3 = new ChatClient(yL1U3kXC, JLzDJTVE);
		players.put(yL1U3kXC, A2NgwUD3);
		return A2NgwUD3;
	}

}