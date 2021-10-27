class n20426057 {
	public static KeyStore createKeyStore(final URL url, final String password)
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		if (url == null)
			throw new IllegalArgumentException("Keystore url may not be null");
		LOG.debug("Initializing key store");
		KeyStore keystore = null;
		keystore = (url.getFile().endsWith(".p12")) ? KeyStore.getInstance("pkcs12")
				: KeyStore.getInstance(KeyStore.getDefaultType());
		keystore.load(url.openStream(), password != null ? password.toCharArray() : null);
		return keystore;
	}

}