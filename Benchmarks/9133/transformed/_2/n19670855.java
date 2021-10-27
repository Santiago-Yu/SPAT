class n19670855 {
	private synchronized void configure() {
		final Map res = new HashMap();
		try {
			final Enumeration resources = getConfigResources();
			SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
			for (; resources.hasMoreElements();) {
				final URL url = (URL) resources.nextElement();
				DefaultHandler saxHandler = new DefaultHandler() {
					private Group group;
					private StringBuffer tagContent = new StringBuffer();

					public void startElement(String uri, String localName, String qName, Attributes attributes)
							throws SAXException {
						if ("group".equals(qName)) {
							group = new Group(attributes.getValue("name"));
							String minimizeJs = attributes.getValue("minimize");
							String minimizeCss = attributes.getValue("minimizeCss");
							group.setMinimize(!"false".equals(minimizeJs));
							group.setMinimizeCss("true".equals(minimizeCss));
						} else if ("js".equals(qName) || "css".equals(qName) || "group-ref".equals(qName))
							tagContent.setLength(0);
					}

					public void characters(char ch[], int start, int length) throws SAXException {
						tagContent.append(ch, start, length);
					}

					public void endElement(String uri, String localName, String qName) throws SAXException {
						if ("group".equals(qName))
							res.put(group.getName(), group);
						else if ("js".equals(qName))
							group.getJsNames().add(tagContent.toString());
						else if ("css".equals(qName))
							group.getCssNames().add(tagContent.toString());
						else if ("group-ref".equals(qName)) {
							String name = tagContent.toString();
							Group subGroup = (Group) res.get(name);
							if (subGroup == null)
								throw new RuntimeException("Error parsing " + url.toString() + " <group-ref>" + name
										+ "</group-ref> unknown");
							group.getSubgroups().add(subGroup);
						}
					}
				};
				try {
					saxParser.parse(url.openStream(), saxHandler);
				} catch (Throwable e) {
					log.warn(e.toString(), e);
					log.warn("Exception " + e.toString() + " ignored, let's move on..");
				}
			}
			configurationFilesMaxModificationTime = findMaxConfigModificationTime();
		} catch (SAXException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		}
		this.groups = res;
	}

}