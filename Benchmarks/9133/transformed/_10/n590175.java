class n590175 {
	private static KeyStore createKeyStore(final URL url, final String password)
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		if (url == null) {
			throw new IllegalArgumentException("Keystore url may not be null");
		}
		LOG.debug("Initializing key store");
		InputStream is = null;
		KeyStore keystore = KeyStore.getInstance("jks");
		try {
			is = url.openStream();
			keystore.load(is, password != null ? password.toCharArray() : null);
		} finally {
			if (is != null)
				is.close();
		}
		return keystore;
	}

}