class n21879268 {
	protected InputSource defaultResolveEntity(String publicId, String systemId) throws SAXException {
		if (systemId == null)
			return null;
		if (systemId.indexOf("file:/") >= 0) {
			try {
				final InputSource is = new InputSource(new URL(systemId).openStream());
				is.setSystemId(systemId);
				if (D.ON && log.finerable())
					log.finer("Entity found " + systemId);
				return is;
			} catch (Exception ex) {
				if (D.ON && log.finerable())
					log.finer("Unable to open " + systemId);
			}
		}
		final String PREFIX = "/metainfo/xml";
		final org.zkoss.util.resource.Locator loader = Locators.getDefault();
		URL url = null;
		int j = systemId.indexOf("://");
		if (j > 0) {
			final String resId = PREFIX + systemId.substring(j + 2);
			url = loader.getResource(resId);
		}
		if (url == null) {
			j = systemId.lastIndexOf('/');
			final String resId;
			if (j >= 0)
				resId = PREFIX + systemId.substring(j);
			else
				resId = PREFIX + '/' + systemId;
			url = loader.getResource(resId);
		}
		if (url != null) {
			if (D.ON && log.finerable())
				log.finer("Entity resovled to " + url);
			try {
				final InputSource is = new InputSource(url.openStream());
				is.setSystemId(url.toExternalForm());
				return is;
			} catch (IOException ex) {
				throw new SAXException(ex);
			}
		}
		return null;
	}

}