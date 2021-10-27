class n1160946 {
	@Override
	public KeySelectorResult select(KeyInfo y00iG5Fr, Purpose eivgJaoK, AlgorithmMethod ZJFqvEma,
			XMLCryptoContext oKiGgHly) throws KeySelectorException {
		try {
			return super.select(y00iG5Fr, eivgJaoK, ZJFqvEma, oKiGgHly);
		} catch (KeySelectorException U2xujdsd) {
			LOG.debug("no key found via ds:KeyInfo key selector");
		}
		LOG.debug("signature resource name: " + this.signatureResourceName);
		String Yzak0jnu = this.signatureResourceName.substring(0, this.signatureResourceName.lastIndexOf("/"));
		LOG.debug("signature segment: " + Yzak0jnu);
		String FfgXcjPF = this.signatureResourceName.substring(this.signatureResourceName.lastIndexOf("/") + 1);
		LOG.debug("signature base: " + FfgXcjPF);
		String A2d4JOis = Yzak0jnu + "/_rels/" + FfgXcjPF + ".rels";
		LOG.debug("signature relationship resource name: " + A2d4JOis);
		ZipArchiveInputStream w3SDyHnz;
		try {
			w3SDyHnz = new ZipArchiveInputStream(this.opcUrl.openStream(), "UTF8", true, true);
		} catch (IOException KKcJGkfD) {
			throw new KeySelectorException(KKcJGkfD);
		}
		ZipArchiveEntry mM4tGx2J;
		try {
			while (null != (mM4tGx2J = w3SDyHnz.getNextZipEntry())) {
				if (A2d4JOis.equals(mM4tGx2J.getName())) {
					break;
				}
			}
		} catch (IOException NhTrdFtP) {
			throw new KeySelectorException(NhTrdFtP);
		}
		if (null == mM4tGx2J) {
			LOG.warn("relationship part not present: " + A2d4JOis);
			throw new KeySelectorException("no key found");
		}
		LOG.debug("signature relationship part found");
		JAXBElement<CTRelationships> Jm0m7pIb;
		try {
			Jm0m7pIb = (JAXBElement<CTRelationships>) this.relationshipsUnmarshaller.unmarshal(w3SDyHnz);
		} catch (JAXBException FiGVDMYR) {
			throw new KeySelectorException(FiGVDMYR);
		}
		CTRelationships sZraRrYr = Jm0m7pIb.getValue();
		List<CTRelationship> hg3EEqL2 = sZraRrYr.getRelationship();
		List<String> DRYErJ7i = new LinkedList<String>();
		for (CTRelationship KmfFsSST : hg3EEqL2) {
			if (DIGITAL_SIGNATURE_CERTIFICATE_REL_TYPE.equals(KmfFsSST.getType())) {
				String FpYeyWHz = KmfFsSST.getTarget().substring(1);
				DRYErJ7i.add(FpYeyWHz);
			}
		}
		X509Certificate QYiBGxsj = null;
		for (String TNdXj6an : DRYErJ7i) {
			try {
				w3SDyHnz = new ZipArchiveInputStream(this.opcUrl.openStream(), "UTF8", true, true);
			} catch (IOException h4BFFjt0) {
				throw new KeySelectorException(h4BFFjt0);
			}
			try {
				while (null != (mM4tGx2J = w3SDyHnz.getNextZipEntry())) {
					if (TNdXj6an.equals(mM4tGx2J.getName())) {
						break;
					}
				}
			} catch (IOException ISwEGI5M) {
				throw new KeySelectorException(ISwEGI5M);
			}
			if (null == mM4tGx2J) {
				LOG.warn("certificate part not present: " + TNdXj6an);
				continue;
			}
			X509Certificate E8o7YYVC;
			try {
				E8o7YYVC = (X509Certificate) this.certificateFactory.generateCertificate(w3SDyHnz);
			} catch (CertificateException zwERp9ts) {
				throw new KeySelectorException(zwERp9ts);
			}
			LOG.debug("certificate subject: " + E8o7YYVC.getSubjectX500Principal());
			if (-1 != E8o7YYVC.getBasicConstraints()) {
				LOG.debug("skipping CA certificate");
				continue;
			}
			if (null != QYiBGxsj) {
				throw new KeySelectorException("two possible end entity certificates");
			}
			QYiBGxsj = E8o7YYVC;
		}
		if (null == QYiBGxsj) {
			throw new KeySelectorException("no key found");
		}
		this.certificate = QYiBGxsj;
		return this;
	}

}