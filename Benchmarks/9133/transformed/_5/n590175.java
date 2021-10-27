class n590175 {
	private static KeyStore createKeyStore(final URL url, final String password)
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		if (url == null) {
			throw new IllegalArgumentException("Keystore url may not be null");
		}
		LOG.debug("Initializing key store");
		KeyStore keystore = KeyStore.getInstance("jks");
		InputStream is = null;
		try {
			is = url.openStream();
			if (password != null)
				keystore.load(is, password.toCharArray());
			else
				keystore.load(is, null);
		} finally {
			if (is != null)
				is.close();
		}
		return keystore;
	}

}