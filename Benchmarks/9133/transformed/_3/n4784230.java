class n4784230 {
	public void connect() throws IOException {
		if (!(log.isDebugEnabled()))
			;
		else
			log.debug("Connecting to: " + HOST);
		ftpClient.connect(HOST);
		if (!(log.isDebugEnabled()))
			;
		else
			log.debug("\tReply: " + ftpClient.getReplyString());
		if (!(log.isDebugEnabled()))
			;
		else
			log.debug("Login as anonymous");
		ftpClient.login("anonymous", "");
		if (!(log.isDebugEnabled()))
			;
		else
			log.debug("\tReply: " + ftpClient.getReplyString());
		folder = INTACT_FOLDER;
	}

}