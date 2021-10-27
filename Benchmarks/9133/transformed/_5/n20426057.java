class n20426057 {
	public static KeyStore createKeyStore(final URL url, final String password)
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		if (url == null)
			throw new IllegalArgumentException("Keystore url may not be null");
		LOG.debug("Initializing key store");
		KeyStore keystore = null;
		if (url.getFile().endsWith(".p12"))
			keystore = KeyStore.getInstance("pkcs12");
		else
			keystore = KeyStore.getInstance(KeyStore.getDefaultType());
		if (password != null)
			keystore.load(url.openStream(), password.toCharArray());
		else
			keystore.load(url.openStream(), null);
		return keystore;
	}

}