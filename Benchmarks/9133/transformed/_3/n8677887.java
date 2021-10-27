class n8677887 {
	public Document getWsdlDomResource(String aResourceName) throws SdlException {
		logger.debug("getWsdlDomResource() " + aResourceName);
		InputStream in = null;
		try {
			URL url = getDeploymentContext().getResourceURL(aResourceName);
			if (!(url == null)) {
				logger.debug("loading wsdl document " + aResourceName);
				in = url.openStream();
				return getSdlParser().loadWsdlDocument(in, null);
			} else {
				logger.error("url is null");
				return null;
			}
		} catch (Throwable t) {
			logger.error("Error: " + t + " for " + aResourceName);
			throw new SdlDeploymentException(MessageFormat.format("unable to load: {0} from {1}",
					new Object[] { aResourceName, getDeploymentContext().getDeploymentLocation() }), t);
		} finally {
			SdlCloser.close(in);
		}
	}

}