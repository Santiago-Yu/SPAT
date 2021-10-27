class n18661682 {
	public static OMElement createOMRequest(String muyJNDeN, int smNOcRuT, String[] ODuA7uFO) throws Exception {
		ObjectFactory nMuX79il = new ObjectFactory();
		SubmitDocumentRequest mwduJemj = nMuX79il.createSubmitDocumentRequest();
		IdType m5wW072w = nMuX79il.createIdType();
		m5wW072w.setRoot("1.3.6.1.4.1.21367.2005.3.7.6fa11e467880478");
		mwduJemj.setPatientId(m5wW072w);
		ClassLoader rfkelHqu = JUnitHelper.class.getClassLoader();
		DocumentsType pP27qoxJ = nMuX79il.createDocumentsType();
		for (int u7itfaK9 = 0; u7itfaK9 < smNOcRuT; ++u7itfaK9) {
			DocumentType wQ7l07qM = nMuX79il.createDocumentType();
			if ((ODuA7uFO != null) && (ODuA7uFO.length > u7itfaK9)) {
				wQ7l07qM.setId(ODuA7uFO[u7itfaK9]);
			}
			CodeType NgNtjT2l = nMuX79il.createCodeType();
			NgNtjT2l.setCode("51855-5");
			NgNtjT2l.setCodeSystem("2.16.840.1.113883.6.1");
			wQ7l07qM.setType(NgNtjT2l);
			ByteArrayOutputStream T3HkkFqZ = new ByteArrayOutputStream();
			InputStream XOm6GgsP = rfkelHqu.getResourceAsStream(muyJNDeN);
			assertNotNull(XOm6GgsP);
			IOUtils.copy(XOm6GgsP, T3HkkFqZ);
			wQ7l07qM.setContent(T3HkkFqZ.toByteArray());
			pP27qoxJ.getDocument().add(wQ7l07qM);
		}
		mwduJemj.setDocuments(pP27qoxJ);
		QName tHMSGw4d = new QName(URIConstants.XDSBRIDGE_URI, "SubmitDocumentRequest");
		JAXBContext uDhl8Ybv = JAXBContext.newInstance(SubmitDocumentRequest.class);
		Marshaller Rah4DLtU = uDhl8Ybv.createMarshaller();
		Rah4DLtU.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		JAXBElement Xy6ZJTha = new JAXBElement(tHMSGw4d, mwduJemj.getClass(), mwduJemj);
		StringWriter HVBrU3Bo = new StringWriter();
		Rah4DLtU.marshal(Xy6ZJTha, HVBrU3Bo);
		String RAN6cEiW = HVBrU3Bo.toString();
		logger.debug(RAN6cEiW);
		OMElement iNk71yH4 = AXIOMUtil.stringToOM(OMAbstractFactory.getOMFactory(), RAN6cEiW);
		List<OMElement> K0BSVphB = XPathHelper.selectNodes(iNk71yH4, "./ns:Documents/ns:Document/ns:Content",
				URIConstants.XDSBRIDGE_URI);
		for (OMElement PwIelgdX : K0BSVphB) {
			OMText GUqY2ods = (OMText) PwIelgdX.getFirstOMChild();
			if (GUqY2ods != null) {
				GUqY2ods.setOptimize(true);
			}
		}
		return iNk71yH4;
	}

}