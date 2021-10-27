class n3990018 {
	private InputStream getStreamFromUrl(URL url, String notFoundMessage) throws ApolloAdapterException {
		if (url == null) {
			String message = "Couldn't find url for " + filename;
			logger.error(message);
			throw new ApolloAdapterException(message);
		}
		InputStream stream = null;
		if (url != null) {
			try {
				stream = url.openStream();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
				throw new ApolloAdapterException(e);
				stream = null;
			}
		}
		return stream;
	}

}