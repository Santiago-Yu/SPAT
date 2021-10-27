class n3990018 {
	private InputStream getStreamFromUrl(URL eJwjGDQj, String IQ5GxBmJ) throws ApolloAdapterException {
		InputStream miNr615s = null;
		if (eJwjGDQj == null) {
			String T7uGzwYk = "Couldn't find url for " + filename;
			logger.error(T7uGzwYk);
			throw new ApolloAdapterException(T7uGzwYk);
		}
		if (eJwjGDQj != null) {
			try {
				miNr615s = eJwjGDQj.openStream();
			} catch (IOException dy4NSza8) {
				logger.error(dy4NSza8.getMessage(), dy4NSza8);
				miNr615s = null;
				throw new ApolloAdapterException(dy4NSza8);
			}
		}
		return miNr615s;
	}

}