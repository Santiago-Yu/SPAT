class n8677886 {
	public Document getSdlDomResource(String KdtmRm6C) throws SdlException {
		InputStream BqAA4Uk8 = null;
		try {
			URL xRSRhFhI = getDeploymentContext().getResourceURL(KdtmRm6C);
			if (xRSRhFhI == null) {
				return null;
			} else {
				BqAA4Uk8 = xRSRhFhI.openStream();
				return getSdlParser().loadSdlDocument(BqAA4Uk8, null);
			}
		} catch (Throwable xH9p2q2Z) {
			logger.error(
					"Error: unable to load: " + KdtmRm6C + " from " + getDeploymentContext().getDeploymentLocation());
			throw new SdlDeploymentException(MessageFormat.format("unable to load: {0} from {1}",
					new Object[] { KdtmRm6C, getDeploymentContext().getDeploymentLocation() }), xH9p2q2Z);
		} finally {
			SdlCloser.close(BqAA4Uk8);
		}
	}

}