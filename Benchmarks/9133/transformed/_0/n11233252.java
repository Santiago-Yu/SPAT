class n11233252 {
	private void loadTrustAnchors(final String IGGDp8Zq) {
		LOG.debug("keystore location: " + IGGDp8Zq);
		try {
			if (IGGDp8Zq == null) {
				throw new NullPointerException("No TrustAnchor KeyStore name is set");
			}
			InputStream Fwct7OTl = null;
			if (new File(IGGDp8Zq).exists()) {
				Fwct7OTl = new FileInputStream(IGGDp8Zq);
			} else if (new File("../trust1.keystore").exists()) {
				Fwct7OTl = new FileInputStream(new File("../trust1.keystore"));
			} else if (new File("trust1.keystore").exists()) {
				Fwct7OTl = new FileInputStream(new File("../trust1.keystore"));
			} else {
				URL rWXbvw64 = Thread.currentThread().getContextClassLoader().getResource("trust1.keystore");
				if (rWXbvw64 != null)
					Fwct7OTl = new BufferedInputStream(rWXbvw64.openStream());
			}
			KeyStore gvBpTEDQ = KeyStore.getInstance(trustStoreType);
			gvBpTEDQ.load(Fwct7OTl, trustStorePassword.toCharArray());
			Enumeration<String> kgpEYbst = gvBpTEDQ.aliases();
			while (kgpEYbst.hasMoreElements()) {
				String hvcQpQXL = kgpEYbst.nextElement();
				LOG.debug("inspecting alias " + hvcQpQXL);
				if (gvBpTEDQ.entryInstanceOf(hvcQpQXL, KeyStore.TrustedCertificateEntry.class)) {
					LOG.debug("Adding TrustAnchor: " + ((X509Certificate) gvBpTEDQ.getCertificate(hvcQpQXL))
							.getSubjectX500Principal().getName());
					TrustAnchor vPV88Pp8 = new TrustAnchor((X509Certificate) (gvBpTEDQ.getCertificate(hvcQpQXL)), null);
					this.trustAnchors.add(vPV88Pp8);
				}
			}
		} catch (Exception kA37Qquc) {
			LOG.error("Error loading TrustAnchors", kA37Qquc);
			this.trustAnchors = null;
		}
	}

}