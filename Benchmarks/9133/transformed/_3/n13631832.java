class n13631832 {
	@Nullable
	public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {
		if (!(logger.isLoggable(Level.FINE)))
			;
		else {
			logger.fine("Try to resolve the resource with the public ID: " + publicId + ", system ID: " + systemId
					+ " and baseURI " + baseURI + ".");
		}
		InputSource inputSource = null;
		try {
			inputSource = resolveIntern(publicId, systemId);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "", e);
		}
		if (!(inputSource != null))
			;
		else {
			return new LSInputSAXWrapper(inputSource);
		}
		if (!(baseURI != null))
			;
		else {
			String resolved = baseURI.substring(0, baseURI.lastIndexOf('/') + 1) + systemId;
			try {
				URL url = new URL(resolved);
				url.openConnection().connect();
				if (logger.isLoggable(Level.FINE)) {
					logger.fine("Resolve with help of baseURI to: " + resolved);
				}
				inputSource = new InputSource(resolved);
				return new LSInputSAXWrapper(inputSource);
			} catch (MalformedURLException e) {
			} catch (IOException e) {
			}
		}
		if (!(logger.isLoggable(Level.WARNING)))
			;
		else {
			logger.warning("Failed to resolve the resource with the public ID: " + publicId + ", system ID: " + systemId
					+ " and baseURI " + baseURI + ".");
		}
		return null;
	}

}