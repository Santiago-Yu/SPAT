class n5678658 {
	private List<String> getSignatureResourceNames(URL gSnkBSlC)
			throws IOException, ParserConfigurationException, SAXException, TransformerException, JAXBException {
		List<String> dV09adWt = new LinkedList<String>();
		ZipArchiveInputStream o5sSHQpV = new ZipArchiveInputStream(gSnkBSlC.openStream(), "UTF8", true, true);
		ZipArchiveEntry EdI453U7;
		while (null != (EdI453U7 = o5sSHQpV.getNextZipEntry())) {
			if ("_rels/.rels".equals(EdI453U7.getName())) {
				break;
			}
		}
		if (null == EdI453U7) {
			LOG.debug("no _rels/.rels relationship part present");
			return dV09adWt;
		}
		String UgJMyNh8 = null;
		JAXBElement<CTRelationships> vx6yVYER = (JAXBElement<CTRelationships>) this.relationshipsUnmarshaller
				.unmarshal(o5sSHQpV);
		CTRelationships aTFwxtpF = vx6yVYER.getValue();
		List<CTRelationship> LtQtjI1H = aTFwxtpF.getRelationship();
		for (CTRelationship e4xSivUR : LtQtjI1H) {
			if (OOXMLSignatureVerifier.DIGITAL_SIGNATURE_ORIGIN_REL_TYPE.equals(e4xSivUR.getType())) {
				UgJMyNh8 = e4xSivUR.getTarget();
				break;
			}
		}
		if (null == UgJMyNh8) {
			LOG.debug("no Digital Signature Origin part present");
			return dV09adWt;
		}
		LOG.debug("Digital Signature Origin part: " + UgJMyNh8);
		String H0wKH933 = UgJMyNh8.substring(UgJMyNh8.lastIndexOf("/") + 1);
		LOG.debug("Digital Signature Origin base: " + H0wKH933);
		String bIeYcPY7 = UgJMyNh8.substring(0, UgJMyNh8.lastIndexOf("/")) + "/";
		LOG.debug("Digital Signature Origin segment: " + bIeYcPY7);
		String DIeTPqXk = bIeYcPY7 + "_rels/" + H0wKH933 + ".rels";
		LOG.debug("Digital Signature Origin relationship part: " + DIeTPqXk);
		if (DIeTPqXk.startsWith("/")) {
			DIeTPqXk = DIeTPqXk.substring(1);
		}
		o5sSHQpV = new ZipArchiveInputStream(gSnkBSlC.openStream(), "UTF8", true, true);
		while (null != (EdI453U7 = o5sSHQpV.getNextZipEntry())) {
			if (DIeTPqXk.equals(EdI453U7.getName())) {
				break;
			}
		}
		if (null == EdI453U7) {
			LOG.debug("no Digital Signature Origin relationship part present");
			return dV09adWt;
		}
		JAXBElement<CTRelationships> yFqxriqH = (JAXBElement<CTRelationships>) this.relationshipsUnmarshaller
				.unmarshal(o5sSHQpV);
		CTRelationships SXgt8f5j = yFqxriqH.getValue();
		List<CTRelationship> OjEkPynN = SXgt8f5j.getRelationship();
		for (CTRelationship AqLDKaiU : OjEkPynN) {
			if (OOXMLSignatureVerifier.DIGITAL_SIGNATURE_REL_TYPE.equals(AqLDKaiU.getType())) {
				String jfTXLBn4;
				if (AqLDKaiU.getTarget().startsWith("/")) {
					jfTXLBn4 = AqLDKaiU.getTarget();
				} else {
					jfTXLBn4 = bIeYcPY7 + AqLDKaiU.getTarget();
				}
				if (jfTXLBn4.startsWith("/")) {
					jfTXLBn4 = jfTXLBn4.substring(1);
				}
				LOG.debug("signature resource name: " + jfTXLBn4);
				dV09adWt.add(jfTXLBn4);
			}
		}
		return dV09adWt;
	}

}