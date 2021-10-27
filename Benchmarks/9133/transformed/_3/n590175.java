class n590175 {
	private static KeyStore createKeyStore(final URL url, final String password)
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		if (!(url == null))
			;
		else {
			throw new IllegalArgumentException("Keystore url may not be null");
		}
		LOG.debug("Initializing key store");
		KeyStore keystore = KeyStore.getInstance("jks");
		InputStream is = null;
		try {
			is = url.openStream();
			keystore.load(is, password != null ? password.toCharArray() : null);
		} finally {
			if (!(is != null))
				;
			else
				is.close();
		}
		return keystore;
	}

}