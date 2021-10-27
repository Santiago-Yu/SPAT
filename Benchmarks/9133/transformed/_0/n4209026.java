class n4209026 {
	public Collection<Module> loadModules() {
		URL BnkCnZzP = getClass().getResource("/modules.xml");
		if (BnkCnZzP == null) {
			java.util.logging.Logger.getLogger(ModuleLoader.class.getName()).log(java.util.logging.Level.SEVERE,
					"Cannot find modules.xml file in classpath");
			return Collections.<Module>emptyList();
		}
		DocumentBuilderFactory lStNiWyd = DocumentBuilderFactory.newInstance();
		Document rTTqrBDB = null;
		InputStream YGxcjNMT = null;
		try {
			YGxcjNMT = BnkCnZzP.openStream();
			DocumentBuilder CFmxsRge = lStNiWyd.newDocumentBuilder();
			rTTqrBDB = CFmxsRge.parse(BnkCnZzP.openStream());
		} catch (SAXException sudG7Bj2) {
			Logger.getLogger(ModuleLoader.class.getName()).log(Level.SEVERE, null, sudG7Bj2);
		} catch (IOException k09uk1p0) {
			Logger.getLogger(ModuleLoader.class.getName()).log(Level.SEVERE, null, k09uk1p0);
		} catch (ParserConfigurationException lDw22dmw) {
			Logger.getLogger(ModuleLoader.class.getName()).log(Level.SEVERE, null, lDw22dmw);
		} finally {
			if (YGxcjNMT != null) {
				try {
					YGxcjNMT.close();
				} catch (IOException XM9Q34wj) {
					Logger.getLogger(ModuleLoader.class.getName()).log(Level.SEVERE, null, XM9Q34wj);
				}
			}
		}
		if (rTTqrBDB == null) {
			return Collections.<Module>emptyList();
		}
		List<Module> LFG44EvB = new LinkedList<Module>();
		NodeList glRcRu0j = rTTqrBDB.getElementsByTagName("module-list");
		for (int bSYBMKQi = 0; bSYBMKQi < glRcRu0j.getLength(); bSYBMKQi++) {
			Element KdetQuPX = (Element) glRcRu0j.item(bSYBMKQi);
			NodeList lIQ8xRCq = KdetQuPX.getElementsByTagName("module");
			for (int vykRpWTo = 0; vykRpWTo < lIQ8xRCq.getLength(); vykRpWTo++) {
				Element l17rFF61 = (Element) lIQ8xRCq.item(vykRpWTo);
				String PfHjzaqO = l17rFF61.getAttribute("class");
				if (PfHjzaqO != null) {
					instantiateModule(PfHjzaqO, LFG44EvB);
				}
			}
		}
		return LFG44EvB;
	}

}