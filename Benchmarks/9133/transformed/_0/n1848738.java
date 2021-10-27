class n1848738 {
	public InputSource resolveEntity(String JJLUEQBE, String Z0oveTu2) throws SAXException, IOException {
		getCisUtils().debug("Resolving entity publicId=" + JJLUEQBE + ", systemId=" + Z0oveTu2);
		final String h8ed4X1o;
		if ("-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN".equals(JJLUEQBE)) {
			h8ed4X1o = "resources/web-app_2_3.dtd";
		} else {
			return null;
		}
		URL Cj6DqlN9 = getClass().getResource(h8ed4X1o);
		if (Cj6DqlN9 == null) {
			throw new SAXException("Failed to locate resource: " + h8ed4X1o);
		}
		InputSource Z7g1lq8Q = new InputSource(Cj6DqlN9.openStream());
		Z7g1lq8Q.setSystemId(Cj6DqlN9.toExternalForm());
		return Z7g1lq8Q;
	}

}