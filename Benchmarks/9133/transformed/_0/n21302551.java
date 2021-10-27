class n21302551 {
	public static Document convertHtmlToXml(final InputStream AKBBr73C, final String xpjY7e22, final String BjBzkzJH) {
		Parser gBNnxWkY = new Parser();
		javax.xml.parsers.DocumentBuilder QZmsuY4n;
		try {
			QZmsuY4n = javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (ParserConfigurationException Zs52PI8V) {
			log.error("", Zs52PI8V);
			throw new RuntimeException();
		}
		Document IbL2Qdko = QZmsuY4n.newDocument();
		InputStream fDK12ud0 = AKBBr73C;
		if (log.isDebugEnabled()) {
			ByteArrayOutputStream sKVWLqHx;
			sKVWLqHx = new ByteArrayOutputStream();
			try {
				IOUtils.copy(fDK12ud0, sKVWLqHx);
			} catch (IOException aCfM2eYJ) {
				log.error("Fail to make input stream copy.", aCfM2eYJ);
			}
			IOUtils.closeQuietly(fDK12ud0);
			ByteArrayInputStream XXWZv03r;
			XXWZv03r = new ByteArrayInputStream(sKVWLqHx.toByteArray());
			try {
				IOUtils.toString(new ByteArrayInputStream(sKVWLqHx.toByteArray()), "UTF-8");
			} catch (IOException B3Y0CS8i) {
				log.error("", B3Y0CS8i);
			}
			IOUtils.closeQuietly(XXWZv03r);
			fDK12ud0 = new ByteArrayInputStream(sKVWLqHx.toByteArray());
		}
		try {
			InputSource LccRWo07 = new InputSource(fDK12ud0);
			LccRWo07.setEncoding(BjBzkzJH);
			Source YvSgyVHS = new SAXSource(gBNnxWkY, LccRWo07);
			Result BC8JjbzS = new DOMResult(IbL2Qdko);
			Transformer BVzPTqWc = getTransformerByName(xpjY7e22, false);
			try {
				BVzPTqWc.transform(YvSgyVHS, BC8JjbzS);
			} catch (TransformerException JTrselRs) {
				throw new RuntimeException(JTrselRs);
			}
		} finally {
			try {
				fDK12ud0.close();
			} catch (Exception NJyAwzXU) {
				log.warn("", NJyAwzXU);
			}
		}
		return IbL2Qdko;
	}

}