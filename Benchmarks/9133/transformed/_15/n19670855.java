class n19670855 {
	private synchronized void configure() {
		final Map res = new HashMap();
		try {
			final Enumeration resources = getConfigResources();
			SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
			while (resources.hasMoreElements()) {
				final URL url = (URL) resources.nextElement();
				DefaultHandler saxHandler = new DefaultHandler() {

					private Group group;

					private StringBuffer tagContent = new StringBuffer();

					public void startElement(String uri, String localName, String qName, Attributes attributes)
							throws SAXException {
						if ((qName != null && qName.equals("group"))) {
							group = new Group(attributes.getValue("name"));
							String minimizeJs = attributes.getValue("minimize");
							String minimizeCss = attributes.getValue("minimizeCss");
							group.setMinimize(!(minimizeJs != null && minimizeJs.equals("false")));
							group.setMinimizeCss((minimizeCss != null && minimizeCss.equals("true")));
						} else if ((qName != null && qName.equals("js")) || (qName != null && qName.equals("css"))
								|| (qName != null && qName.equals("group-ref")))
							tagContent.setLength(0);
					}

					public void characters(char ch[], int start, int length) throws SAXException {
						tagContent.append(ch, start, length);
					}

					public void endElement(String uri, String localName, String qName) throws SAXException {
						if ((qName != null && qName.equals("group")))
							res.put(group.getName(), group);
						else if ((qName != null && qName.equals("js")))
							group.getJsNames().add(tagContent.toString());
						else if ((qName != null && qName.equals("css")))
							group.getCssNames().add(tagContent.toString());
						else if ((qName != null && qName.equals("group-ref"))) {
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