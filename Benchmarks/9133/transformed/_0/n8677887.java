class n8677887 {
	public Document getWsdlDomResource(String d1CAY6Az) throws SdlException {
		logger.debug("getWsdlDomResource() " + d1CAY6Az);
		InputStream zpGdwR6M = null;
		try {
			URL SxvdP3Bk = getDeploymentContext().getResourceURL(d1CAY6Az);
			if (SxvdP3Bk == null) {
				logger.error("url is null");
				return null;
			} else {
				logger.debug("loading wsdl document " + d1CAY6Az);
				zpGdwR6M = SxvdP3Bk.openStream();
				return getSdlParser().loadWsdlDocument(zpGdwR6M, null);
			}
		} catch (Throwable sJsB5s09) {
			logger.error("Error: " + sJsB5s09 + " for " + d1CAY6Az);
			throw new SdlDeploymentException(MessageFormat.format("unable to load: {0} from {1}",
					new Object[] { d1CAY6Az, getDeploymentContext().getDeploymentLocation() }), sJsB5s09);
		} finally {
			SdlCloser.close(zpGdwR6M);
		}
	}

}