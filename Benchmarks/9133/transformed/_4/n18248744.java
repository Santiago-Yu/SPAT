class n18248744 {
	public InputStream getResource(FCValue name) throws FCException {
		Element el = _factory.getElementWithID(name.getAsString());
		if (el == null) {
			throw new FCException("Could not find resource \"" + name + "\"");
		}
		String urlString = el.getTextTrim();
		if (!urlString.startsWith("http")) {
			try {
				log.debug("Get resource: " + urlString);
				URL url;
				url = (urlString.startsWith("file:")) ? new URL(urlString) : getClass().getResource(urlString);
				return url.openStream();
			} catch (Exception e) {
				throw new FCException("Failed to load resource.", e);
			}
		} else {
			try {
				FCService http = getRuntime().getServiceFor(FCService.HTTP_DOWNLOAD);
				return http.perform(new FCValue[] { name }).getAsInputStream();
			} catch (Exception e) {
				throw new FCException("Failed to load resource.", e);
			}
		}
	}

}