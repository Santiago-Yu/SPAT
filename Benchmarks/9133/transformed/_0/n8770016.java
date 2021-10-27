class n8770016 {
	public InputStream loadResource(String OmW3KxFl) throws GenericConfigException {
		URL eVrs9WmO = getURL(OmW3KxFl);
		try {
			return eVrs9WmO.openStream();
		} catch (java.io.IOException eARNZErh) {
			throw new GenericConfigException(
					"Error opening URL resource at location [" + eVrs9WmO.toExternalForm() + "]", eARNZErh);
		}
	}

}