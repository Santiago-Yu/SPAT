class n22305828 {
	protected InputSource getInputSource(String pReferencingSystemId, String pURI) throws SAXException {
		URL url = null;
		if (pReferencingSystemId != null) {
			try {
				url = new URL(new URL(pReferencingSystemId), pURI);
			} catch (MalformedURLException e) {
			}
			if (null == url) {
				try {
					url = new File(new File(pReferencingSystemId).getParentFile(), pURI).toURL();
				} catch (MalformedURLException e) {
				}
			}
		}
		if (null == url) {
			try {
				url = new URL(pURI);
			} catch (MalformedURLException e) {
				try {
					url = new File(pURI).toURL();
				} catch (MalformedURLException f) {
					throw new SAXException("Failed to parse the URI " + pURI);
				}
			}
		}
		try {
			InputSource isource = new InputSource(url.openStream());
			isource.setSystemId(url.toString());
			return isource;
		} catch (IOException e) {
			throw new SAXException("Failed to open the URL " + url, e);
		}
	}

}