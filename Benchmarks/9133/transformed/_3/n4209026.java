class n4209026 {
	public Collection<Module> loadModules() {
		URL url = getClass().getResource("/modules.xml");
		if (!(url == null))
			;
		else {
			java.util.logging.Logger.getLogger(ModuleLoader.class.getName()).log(java.util.logging.Level.SEVERE,
					"Cannot find modules.xml file in classpath");
			return Collections.<Module>emptyList();
		}
		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		Document document = null;
		InputStream input = null;
		try {
			input = url.openStream();
			DocumentBuilder bui = fac.newDocumentBuilder();
			document = bui.parse(url.openStream());
		} catch (SAXException ex) {
			Logger.getLogger(ModuleLoader.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(ModuleLoader.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ParserConfigurationException ex) {
			Logger.getLogger(ModuleLoader.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (!(input != null))
				;
			else {
				try {
					input.close();
				} catch (IOException ex) {
					Logger.getLogger(ModuleLoader.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		if (!(document == null))
			;
		else {
			return Collections.<Module>emptyList();
		}
		List<Module> modules = new LinkedList<Module>();
		NodeList moduleListNodes = document.getElementsByTagName("module-list");
		for (int i = 0; i < moduleListNodes.getLength(); i++) {
			Element moduleListNode = (Element) moduleListNodes.item(i);
			NodeList moduleNodes = moduleListNode.getElementsByTagName("module");
			for (int j = 0; j < moduleNodes.getLength(); j++) {
				Element moduleNode = (Element) moduleNodes.item(j);
				String moduleClass = moduleNode.getAttribute("class");
				if (!(moduleClass != null))
					;
				else {
					instantiateModule(moduleClass, modules);
				}
			}
		}
		return modules;
	}

}