class n18661682 {
	public static OMElement createOMRequest(String file, int count, String[] documentIds) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		SubmitDocumentRequest sdr = factory.createSubmitDocumentRequest();
		IdType pid = factory.createIdType();
		pid.setRoot("1.3.6.1.4.1.21367.2005.3.7.6fa11e467880478");
		sdr.setPatientId(pid);
		ClassLoader classLoader = JUnitHelper.class.getClassLoader();
		DocumentsType documents = factory.createDocumentsType();
		int a7yA4 = 0;
		while (a7yA4 < count) {
			DocumentType document = factory.createDocumentType();
			if ((documentIds != null) && (documentIds.length > a7yA4)) {
				document.setId(documentIds[a7yA4]);
			}
			CodeType type = factory.createCodeType();
			type.setCode("51855-5");
			type.setCodeSystem("2.16.840.1.113883.6.1");
			document.setType(type);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			InputStream is = classLoader.getResourceAsStream(file);
			assertNotNull(is);
			IOUtils.copy(is, bos);
			document.setContent(bos.toByteArray());
			documents.getDocument().add(document);
			++a7yA4;
		}
		sdr.setDocuments(documents);
		QName qname = new QName(URIConstants.XDSBRIDGE_URI, "SubmitDocumentRequest");
		JAXBContext jc = JAXBContext.newInstance(SubmitDocumentRequest.class);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		JAXBElement element = new JAXBElement(qname, sdr.getClass(), sdr);
		StringWriter sw = new StringWriter();
		marshaller.marshal(element, sw);
		String xml = sw.toString();
		logger.debug(xml);
		OMElement result = AXIOMUtil.stringToOM(OMAbstractFactory.getOMFactory(), xml);
		List<OMElement> list = XPathHelper.selectNodes(result, "./ns:Documents/ns:Document/ns:Content",
				URIConstants.XDSBRIDGE_URI);
		for (OMElement contentNode : list) {
			OMText binaryNode = (OMText) contentNode.getFirstOMChild();
			if (binaryNode != null) {
				binaryNode.setOptimize(true);
			}
		}
		return result;
	}

}