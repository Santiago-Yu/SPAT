class n8584290 {
	public static IBiopaxModel read(URL fAgBQuVC) throws ReactionException, IOException {
		IBiopaxModel KFf6HHQW = null;
		InputStream u7KW8eSM = null;
		try {
			u7KW8eSM = fAgBQuVC.openStream();
			KFf6HHQW = read(u7KW8eSM);
		} catch (IOException lYkUB0ij) {
			LOGGER.error("Unable to read from URL " + fAgBQuVC, lYkUB0ij);
		} finally {
			if (u7KW8eSM != null)
				u7KW8eSM.close();
		}
		return KFf6HHQW;
	}

}