class n5630314 {
	public Document getWsdlDomResource(String QSnbzT8y) throws AeException {
		logger.debug("getWsdlDomResource() " + QSnbzT8y);
		InputStream LRg6nuFE = null;
		try {
			URL jIitiBXZ = getDeploymentContext().getResourceURL(QSnbzT8y);
			if (jIitiBXZ == null) {
				logger.error("url is null");
				return null;
			} else {
				logger.debug("loading wsdl document " + QSnbzT8y);
				LRg6nuFE = jIitiBXZ.openStream();
				return getSdlParser().loadWsdlDocument(LRg6nuFE, null);
			}
		} catch (Throwable svYO18aB) {
			logger.error("Error: " + svYO18aB + " for " + QSnbzT8y);
			throw new SdlDeploymentException(MessageFormat.format("unable to load: {0} from {1}",
					new Object[] { QSnbzT8y, getDeploymentContext().getDeploymentLocation() }), svYO18aB);
		} finally {
			AeCloser.close(LRg6nuFE);
		}
	}

}