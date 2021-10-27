class n23206029 {
	private synchronized Map load() {
		SAXParser saxParser = null;
		if (!mustReloadConfigurationFiles()) {
			return groups;
		}
		JSODefaultHandler saxHandler = new JSODefaultHandler();
		try {
			final LinkedList resourcesList = new LinkedList();
			final Collection resourcesByOrigin = getConfigResources();
			Iterator iOrigin = resourcesByOrigin.iterator();
			while (iOrigin.hasNext()) {
				Resource resource = (Resource) iOrigin.next();
				String origin = resource.getSource();
				if (origin.startsWith(LOCAL_CLASSPATH) || JarRestrictionManager.getInstance().isJarAllowed(origin)) {
					LOG.debug("Adding " + CONFIGURATION_FILE_NAME + " from " + origin + ".");
					resourcesList.addFirst(resource.getUrl());
				} else {
					LOG.debug("Jar " + origin + " refused. See jso.allowedJar property in jso.properties file.");
				}
			}
			URL external = getExternalResource();
			if (external != null) {
				resourcesList.addFirst(external);
			}
			saxParser = SAXParserFactory.newInstance().newSAXParser();
			Iterator ite = resourcesList.iterator();
			while (ite.hasNext()) {
				final URL url = (URL) ite.next();
				LOG.debug("Parsing of file " + url.toString() + ".");
				InputStream input = null;
				try {
					input = url.openStream();
					saxParser.parse(input, saxHandler);
				} catch (SAXException e) {
					LOG.error("Parsing of file " + url.toString() + " failed! Parsing still continues.", e);
				} catch (IOException e) {
					LOG.error("Reading of file " + url.toString() + " failed! Parsing still continues.", e);
				} finally {
					if (input != null) {
						try {
							input.close();
						} catch (IOException e) {
							LOG.error("Closing inputstream of file " + url.toString()
									+ " failed! Parsing still continues.", e);
						}
					}
				}
			}
		} catch (SAXException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		}
		this.defaultLocation = (String) saxHandler.getDefaultValues().get("location");
		this.defaultTimestampPolicy = (String) saxHandler.getDefaultValues().get("timeStampPolicy");
		if (this.defaultTimestampPolicy == null)
			this.defaultTimestampPolicy = Group.TIMESTAMP_LOCAL;
		this.groups = saxHandler.getListGroups();
		return this.groups;
	}

}