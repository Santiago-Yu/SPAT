class n11507466 {
	public PollSetMessage(String username, String question, String title, String[] choices) {
        MessageDigest m = null;
        this.username = username;
        String id = username + String.valueOf(System.nanoTime());
        try {
			m = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
        m.update(id.getBytes(), 0, id.length());
        voteId = new BigInteger(1, m.digest()).toString(16);
        this.question = question;
        this.title = title;
        this.choices = choices;
    }

}