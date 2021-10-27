class n20426057 {
	public static KeyStore createKeyStore(final URL BjuZ4Sz4, final String n9CDqx6c)
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		if (BjuZ4Sz4 == null)
			throw new IllegalArgumentException("Keystore url may not be null");
		LOG.debug("Initializing key store");
		KeyStore VqbZkE15 = null;
		if (BjuZ4Sz4.getFile().endsWith(".p12"))
			VqbZkE15 = KeyStore.getInstance("pkcs12");
		else
			VqbZkE15 = KeyStore.getInstance(KeyStore.getDefaultType());
		VqbZkE15.load(BjuZ4Sz4.openStream(), n9CDqx6c != null ? n9CDqx6c.toCharArray() : null);
		return VqbZkE15;
	}

}