class n590175 {
	private static KeyStore createKeyStore(final URL OhQoybzt, final String ckXFVKub)
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		if (OhQoybzt == null) {
			throw new IllegalArgumentException("Keystore url may not be null");
		}
		LOG.debug("Initializing key store");
		KeyStore KKRpPLIp = KeyStore.getInstance("jks");
		InputStream qGfIGJPB = null;
		try {
			qGfIGJPB = OhQoybzt.openStream();
			KKRpPLIp.load(qGfIGJPB, ckXFVKub != null ? ckXFVKub.toCharArray() : null);
		} finally {
			if (qGfIGJPB != null)
				qGfIGJPB.close();
		}
		return KKRpPLIp;
	}

}