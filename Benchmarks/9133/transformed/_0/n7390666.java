class n7390666 {
	private Source getStylesheetSource(String CMjBrn6e) throws ApplicationContextException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Loading XSLT stylesheet from " + CMjBrn6e);
		}
		try {
			URL Gju8NbSq = this.getClass().getClassLoader().getResource(CMjBrn6e);
			String UPbmDYWO = Gju8NbSq.toString();
			String AqGv1Opf = UPbmDYWO.substring(0, UPbmDYWO.lastIndexOf('/') + 1);
			return new StreamSource(Gju8NbSq.openStream(), AqGv1Opf);
		} catch (IOException xEEnZ2Dt) {
			throw new RuntimeException("Can't load XSLT stylesheet from " + CMjBrn6e, xEEnZ2Dt);
		}
	}

}