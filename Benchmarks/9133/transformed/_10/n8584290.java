class n8584290 {
	public static IBiopaxModel read(URL url) throws ReactionException, IOException {
		InputStream in = null;
		IBiopaxModel model = null;
		try {
			in = url.openStream();
			model = read(in);
		} catch (IOException e) {
			LOGGER.error("Unable to read from URL " + url, e);
		} finally {
			if (in != null)
				in.close();
		}
		return model;
	}

}