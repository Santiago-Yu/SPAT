class n19172809 {
	public static Document parseDocument(Object toParse, boolean isFile, List<ErrorMessage> errorMessages) {
		Document document = null;
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			docBuilderFactory.setValidating(true);
			docBuilderFactory.setNamespaceAware(true);
			docBuilderFactory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
					"http://www.w3.org/2001/XMLSchema");
			docBuilderFactory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource", "BPMN20.xsd");
			BPMNModelParsingErrors pErrors = new BPMNModelParsingErrors();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			docBuilder.setErrorHandler(pErrors);
			docBuilder.setEntityResolver(new BPMNModelEntityResolver());
			if (isFile) {
				String filepath = toParse.toString();
				File f = new File(filepath);
				if (!f.exists()) {
					URL url = BPMNModelUtils.class.getResource(filepath);
					if (url == null) {
						if (filepath.startsWith("http") || filepath.startsWith("ftp")) {
							url = new URL(filepath);
						}
					}
					if (url != null) {
						document = docBuilder.parse(url.openStream());
					}
				} else {
					if (filepath.endsWith(".gz")) {
						document = docBuilder.parse(new GZIPInputStream(new FileInputStream(f)));
					} else {
						document = docBuilder.parse(new FileInputStream(f));
					}
				}
			} else {
				if (toParse instanceof String) {
					document = docBuilder.parse(new InputSource(new StringReader(toParse.toString())));
				} else if (toParse instanceof InputStream) {
					document = docBuilder.parse((InputStream) toParse);
				}
			}
			errorMessages.addAll(pErrors.getErrorMessages());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}

}