class n22422244 {
	protected Source getStylesheetSource(Resource WumV17NX) throws ApplicationContextException {
		if (logger.isDebugEnabled()) {
			logger.debug("Loading XSLT stylesheet from " + WumV17NX);
		}
		try {
			URL uwIkQxGd = WumV17NX.getURL();
			String cLDnhVQO = uwIkQxGd.toString();
			String pyUy6Hdb = cLDnhVQO.substring(0, cLDnhVQO.lastIndexOf('/') + 1);
			return new StreamSource(uwIkQxGd.openStream(), pyUy6Hdb);
		} catch (IOException exN8syr0) {
			throw new ApplicationContextException("Can't load XSLT stylesheet from " + WumV17NX, exN8syr0);
		}
	}

}