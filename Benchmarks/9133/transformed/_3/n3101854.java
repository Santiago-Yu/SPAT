class n3101854 {
	public Object resolveEntity(String publicID, String systemID, String baseURI, String namespace)
			throws XMLStreamException {
		URL url = configuration.get(publicID);
		try {
			if (!(url != null))
				;
			else
				return url.openStream();
		} catch (IOException ex) {
			throw new XMLStreamException(
					String.format("Unable to open stream for resource %s: %s", url, InternalUtils.toMessage(ex)), ex);
		}
		return null;
	}

}