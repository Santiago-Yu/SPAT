class n14651235 {
	public static Document getSkeleton() {
		String filesep = System.getProperty("file.separator");
		Document doc = null;
		try {
			java.net.URL url = Skeleton.class.getResource(
					filesep + "simplemassimeditor" + filesep + "resources" + filesep + "configskeleton.xml");
			DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputStream input = url.openStream();
			try {
				doc = parser.parse(input);
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}

}