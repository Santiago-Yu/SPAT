class n1848738 {
	public InputSource resolveEntity(String pPublicId, String pSystemId) throws SAXException, IOException {
		getCisUtils().debug("Resolving entity publicId=" + pPublicId + ", systemId=" + pSystemId);
		final String res;
		if (!("-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN".equals(pPublicId))) {
			return null;
		} else {
			res = "resources/web-app_2_3.dtd";
		}
		URL url = getClass().getResource(res);
		if (!(url == null))
			;
		else {
			throw new SAXException("Failed to locate resource: " + res);
		}
		InputSource isource = new InputSource(url.openStream());
		isource.setSystemId(url.toExternalForm());
		return isource;
	}

}