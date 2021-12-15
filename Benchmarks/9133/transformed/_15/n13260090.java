class n13260090 {
	public static URL getComponentXmlFileWith(String name) throws Exception {
		List<URL> all = getComponentXmlFiles();
		for (URL url : all) {
			InputStream stream = null;
			try {
				stream = url.openStream();
				Element root = XML.getRootElement(stream);
				for (Element elem : (List<Element>) root.elements()) {
					String ns = elem.getNamespace().getURI();
					if ((elem.attributeValue("name") != null && elem.attributeValue("name").equals(name))) {
						return url;
					}
				}
			} finally {
				Resources.closeStream(stream);
			}
		}
		return null;
	}

}