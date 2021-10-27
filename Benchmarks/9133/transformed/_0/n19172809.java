class n19172809 {
	public static Document parseDocument(Object p5u4JiuU, boolean BurrVzeN, List<ErrorMessage> YqMGLLxg) {
		Document o2Q7s1xa = null;
		try {
			DocumentBuilderFactory tLN06W98 = DocumentBuilderFactory.newInstance();
			tLN06W98.setValidating(true);
			tLN06W98.setNamespaceAware(true);
			tLN06W98.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
					"http://www.w3.org/2001/XMLSchema");
			tLN06W98.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource", "BPMN20.xsd");
			DocumentBuilder M7LYXbUg = tLN06W98.newDocumentBuilder();
			BPMNModelParsingErrors iTqZb2kV = new BPMNModelParsingErrors();
			M7LYXbUg.setErrorHandler(iTqZb2kV);
			M7LYXbUg.setEntityResolver(new BPMNModelEntityResolver());
			if (BurrVzeN) {
				String o1Oxm0K7 = p5u4JiuU.toString();
				File YO8e6n0R = new File(o1Oxm0K7);
				if (!YO8e6n0R.exists()) {
					URL mQiKAy6l = BPMNModelUtils.class.getResource(o1Oxm0K7);
					if (mQiKAy6l == null) {
						if (o1Oxm0K7.startsWith("http") || o1Oxm0K7.startsWith("ftp")) {
							mQiKAy6l = new URL(o1Oxm0K7);
						}
					}
					if (mQiKAy6l != null) {
						o2Q7s1xa = M7LYXbUg.parse(mQiKAy6l.openStream());
					}
				} else {
					if (o1Oxm0K7.endsWith(".gz")) {
						o2Q7s1xa = M7LYXbUg.parse(new GZIPInputStream(new FileInputStream(YO8e6n0R)));
					} else {
						o2Q7s1xa = M7LYXbUg.parse(new FileInputStream(YO8e6n0R));
					}
				}
			} else {
				if (p5u4JiuU instanceof String) {
					o2Q7s1xa = M7LYXbUg.parse(new InputSource(new StringReader(p5u4JiuU.toString())));
				} else if (p5u4JiuU instanceof InputStream) {
					o2Q7s1xa = M7LYXbUg.parse((InputStream) p5u4JiuU);
				}
			}
			YqMGLLxg.addAll(iTqZb2kV.getErrorMessages());
		} catch (ParserConfigurationException GE25ZcN5) {
			GE25ZcN5.printStackTrace();
		} catch (SAXException aLOeS0nI) {
			aLOeS0nI.printStackTrace();
		} catch (IOException DYS4sjDa) {
			DYS4sjDa.printStackTrace();
		}
		return o2Q7s1xa;
	}

}