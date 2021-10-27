class n8232814 {
	public ChatClient registerPlayer(int lZQjazKx, String R2aS8urx)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest dNxcur6m = MessageDigest.getInstance("SHA-256");
		dNxcur6m.reset();
		dNxcur6m.update(R2aS8urx.getBytes("UTF-8"), 0, R2aS8urx.length());
		byte[] FIgCVu6o = dNxcur6m.digest();
		byte[] RY99AoQA = generateToken(FIgCVu6o);
		ChatClient MThLWDXR = new ChatClient(lZQjazKx, RY99AoQA);
		players.put(lZQjazKx, MThLWDXR);
		return MThLWDXR;
	}

}