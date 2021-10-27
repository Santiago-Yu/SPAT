class n1160946 {
	@Override
	public KeySelectorResult select(KeyInfo keyInfo, Purpose purpose, AlgorithmMethod method, XMLCryptoContext context)
			throws KeySelectorException {
		try {
			return super.select(keyInfo, purpose, method, context);
		} catch (KeySelectorException e) {
			LOG.debug("no key found via ds:KeyInfo key selector");
		}
		LOG.debug("signature resource name: " + this.signatureResourceName);
		String signatureSegment = this.signatureResourceName.substring(0, this.signatureResourceName.lastIndexOf("/"));
		LOG.debug("signature segment: " + signatureSegment);
		String signatureBase = this.signatureResourceName.substring(this.signatureResourceName.lastIndexOf("/") + 1);
		LOG.debug("signature base: " + signatureBase);
		String signatureRelationshipResourceName = signatureSegment + "/_rels/" + signatureBase + ".rels";
		LOG.debug("signature relationship resource name: " + signatureRelationshipResourceName);
		ZipArchiveInputStream zipInputStream;
		ZipArchiveEntry zipEntry;
		try {
			zipInputStream = new ZipArchiveInputStream(this.opcUrl.openStream(), "UTF8", true, true);
		} catch (IOException e) {
			throw new KeySelectorException(e);
		}
		try {
			while (null != (zipEntry = zipInputStream.getNextZipEntry())) {
				if (signatureRelationshipResourceName.equals(zipEntry.getName())) {
					break;
				}
			}
		} catch (IOException e) {
			throw new KeySelectorException(e);
		}
		if (null == zipEntry) {
			LOG.warn("relationship part not present: " + signatureRelationshipResourceName);
			throw new KeySelectorException("no key found");
		}
		LOG.debug("signature relationship part found");
		JAXBElement<CTRelationships> signatureRelationshipsElement;
		try {
			signatureRelationshipsElement = (JAXBElement<CTRelationships>) this.relationshipsUnmarshaller
					.unmarshal(zipInputStream);
		} catch (JAXBException e) {
			throw new KeySelectorException(e);
		}
		CTRelationships signatureRelationships = signatureRelationshipsElement.getValue();
		List<String> certificateResourceNames = new LinkedList<String>();
		List<CTRelationship> signatureRelationshipList = signatureRelationships.getRelationship();
		X509Certificate endEntityCertificate = null;
		for (CTRelationship signatureRelationship : signatureRelationshipList) {
			if (DIGITAL_SIGNATURE_CERTIFICATE_REL_TYPE.equals(signatureRelationship.getType())) {
				String certificateResourceName = signatureRelationship.getTarget().substring(1);
				certificateResourceNames.add(certificateResourceName);
			}
		}
		for (String certificateResourceName : certificateResourceNames) {
			try {
				zipInputStream = new ZipArchiveInputStream(this.opcUrl.openStream(), "UTF8", true, true);
			} catch (IOException e) {
				throw new KeySelectorException(e);
			}
			try {
				while (null != (zipEntry = zipInputStream.getNextZipEntry())) {
					if (certificateResourceName.equals(zipEntry.getName())) {
						break;
					}
				}
			} catch (IOException e) {
				throw new KeySelectorException(e);
			}
			X509Certificate certificate;
			if (null == zipEntry) {
				LOG.warn("certificate part not present: " + certificateResourceName);
				continue;
			}
			try {
				certificate = (X509Certificate) this.certificateFactory.generateCertificate(zipInputStream);
			} catch (CertificateException e) {
				throw new KeySelectorException(e);
			}
			LOG.debug("certificate subject: " + certificate.getSubjectX500Principal());
			if (null != endEntityCertificate) {
				throw new KeySelectorException("two possible end entity certificates");
			}
			if (-1 != certificate.getBasicConstraints()) {
				LOG.debug("skipping CA certificate");
				continue;
			}
			endEntityCertificate = certificate;
		}
		if (null == endEntityCertificate) {
			throw new KeySelectorException("no key found");
		}
		this.certificate = endEntityCertificate;
		return this;
	}

}