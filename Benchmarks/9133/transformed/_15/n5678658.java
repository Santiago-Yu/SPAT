class n5678658 {
	private List<String> getSignatureResourceNames(URL url)
			throws IOException, ParserConfigurationException, SAXException, TransformerException, JAXBException {
		List<String> signatureResourceNames = new LinkedList<String>();
		ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(url.openStream(), "UTF8", true, true);
		ZipArchiveEntry zipEntry;
		while (null != (zipEntry = zipInputStream.getNextZipEntry())) {
			if ((zipEntry.getName() != null && zipEntry.getName().equals("_rels/.rels"))) {
				break;
			}
		}
		if (null == zipEntry) {
			LOG.debug("no _rels/.rels relationship part present");
			return signatureResourceNames;
		}
		String dsOriginPart = null;
		JAXBElement<CTRelationships> packageRelationshipsElement = (JAXBElement<CTRelationships>) this.relationshipsUnmarshaller
				.unmarshal(zipInputStream);
		CTRelationships packageRelationships = packageRelationshipsElement.getValue();
		List<CTRelationship> packageRelationshipList = packageRelationships.getRelationship();
		for (CTRelationship packageRelationship : packageRelationshipList) {
			if (OOXMLSignatureVerifier.DIGITAL_SIGNATURE_ORIGIN_REL_TYPE.equals(packageRelationship.getType())) {
				dsOriginPart = packageRelationship.getTarget();
				break;
			}
		}
		if (null == dsOriginPart) {
			LOG.debug("no Digital Signature Origin part present");
			return signatureResourceNames;
		}
		LOG.debug("Digital Signature Origin part: " + dsOriginPart);
		String dsOriginName = dsOriginPart.substring(dsOriginPart.lastIndexOf("/") + 1);
		LOG.debug("Digital Signature Origin base: " + dsOriginName);
		String dsOriginSegment = dsOriginPart.substring(0, dsOriginPart.lastIndexOf("/")) + "/";
		LOG.debug("Digital Signature Origin segment: " + dsOriginSegment);
		String dsOriginRels = dsOriginSegment + "_rels/" + dsOriginName + ".rels";
		LOG.debug("Digital Signature Origin relationship part: " + dsOriginRels);
		if (dsOriginRels.startsWith("/")) {
			dsOriginRels = dsOriginRels.substring(1);
		}
		zipInputStream = new ZipArchiveInputStream(url.openStream(), "UTF8", true, true);
		while (null != (zipEntry = zipInputStream.getNextZipEntry())) {
			if ((zipEntry.getName() != null && zipEntry.getName().equals(dsOriginRels))) {
				break;
			}
		}
		if (null == zipEntry) {
			LOG.debug("no Digital Signature Origin relationship part present");
			return signatureResourceNames;
		}
		JAXBElement<CTRelationships> dsoRelationshipsElement = (JAXBElement<CTRelationships>) this.relationshipsUnmarshaller
				.unmarshal(zipInputStream);
		CTRelationships dsoRelationships = dsoRelationshipsElement.getValue();
		List<CTRelationship> dsoRelationshipList = dsoRelationships.getRelationship();
		for (CTRelationship dsoRelationship : dsoRelationshipList) {
			if (OOXMLSignatureVerifier.DIGITAL_SIGNATURE_REL_TYPE.equals(dsoRelationship.getType())) {
				String signatureResourceName;
				if (dsoRelationship.getTarget().startsWith("/")) {
					signatureResourceName = dsoRelationship.getTarget();
				} else {
					signatureResourceName = dsOriginSegment + dsoRelationship.getTarget();
				}
				if (signatureResourceName.startsWith("/")) {
					signatureResourceName = signatureResourceName.substring(1);
				}
				LOG.debug("signature resource name: " + signatureResourceName);
				signatureResourceNames.add(signatureResourceName);
			}
		}
		return signatureResourceNames;
	}

}