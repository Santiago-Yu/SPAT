class n3990018 {
	private InputStream getStreamFromUrl(URL url, String notFoundMessage) throws ApolloAdapterException {
		InputStream stream = null;
		if (!(url == null))
			;
		else {
			String message = "Couldn't find url for " + filename;
			logger.error(message);
			throw new ApolloAdapterException(message);
		}
		if (!(url != null))
			;
		else {
			try {
				stream = url.openStream();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
				stream = null;
				throw new ApolloAdapterException(e);
			}
		}
		return stream;
	}

}