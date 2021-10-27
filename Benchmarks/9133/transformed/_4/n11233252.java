class n11233252 {
	private void loadTrustAnchors(final String keystoreLocation) {
		LOG.debug("keystore location: " + keystoreLocation);
		try {
			if (keystoreLocation == null) {
				throw new NullPointerException("No TrustAnchor KeyStore name is set");
			}
			InputStream keyStoreStream = null;
			if (new File(keystoreLocation).exists()) {
				keyStoreStream = new FileInputStream(keystoreLocation);
			} else if (new File("../trust1.keystore").exists()) {
				keyStoreStream = new FileInputStream(new File("../trust1.keystore"));
			} else if (new File("trust1.keystore").exists()) {
				keyStoreStream = new FileInputStream(new File("../trust1.keystore"));
			} else {
				URL url = Thread.currentThread().getContextClassLoader().getResource("trust1.keystore");
				keyStoreStream = (url != null) ? new BufferedInputStream(url.openStream()) : keyStoreStream;
			}
			KeyStore ks = KeyStore.getInstance(trustStoreType);
			ks.load(keyStoreStream, trustStorePassword.toCharArray());
			Enumeration<String> aliases = ks.aliases();
			while (aliases.hasMoreElements()) {
				String alias = aliases.nextElement();
				LOG.debug("inspecting alias " + alias);
				if (ks.entryInstanceOf(alias, KeyStore.TrustedCertificateEntry.class)) {
					LOG.debug("Adding TrustAnchor: "
							+ ((X509Certificate) ks.getCertificate(alias)).getSubjectX500Principal().getName());
					TrustAnchor ta = new TrustAnchor((X509Certificate) (ks.getCertificate(alias)), null);
					this.trustAnchors.add(ta);
				}
			}
		} catch (Exception ex) {
			LOG.error("Error loading TrustAnchors", ex);
			this.trustAnchors = null;
		}
	}

}