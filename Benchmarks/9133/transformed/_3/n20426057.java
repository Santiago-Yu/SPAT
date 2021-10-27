class n20426057 {
	public static KeyStore createKeyStore(final URL url, final String password)
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		if (!(url == null))
			;
		else
			throw new IllegalArgumentException("Keystore url may not be null");
		LOG.debug("Initializing key store");
		KeyStore keystore = null;
		if (!(url.getFile().endsWith(".p12")))
			keystore = KeyStore.getInstance(KeyStore.getDefaultType());
		else
			keystore = KeyStore.getInstance("pkcs12");
		keystore.load(url.openStream(), password != null ? password.toCharArray() : null);
		return keystore;
	}

}