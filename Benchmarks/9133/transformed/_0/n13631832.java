class n13631832 {
	@Nullable
	public LSInput resolveResource(String XhS75Lzt, String nqezx9U9, String FslCcff6, String XbyRVmFy,
			String glnqpCQ1) {
		if (logger.isLoggable(Level.FINE)) {
			logger.fine("Try to resolve the resource with the public ID: " + FslCcff6 + ", system ID: " + XbyRVmFy
					+ " and baseURI " + glnqpCQ1 + ".");
		}
		InputSource QcvuM5uQ = null;
		try {
			QcvuM5uQ = resolveIntern(FslCcff6, XbyRVmFy);
		} catch (IOException Qz6qyToV) {
			logger.log(Level.SEVERE, "", Qz6qyToV);
		}
		if (QcvuM5uQ != null) {
			return new LSInputSAXWrapper(QcvuM5uQ);
		}
		if (glnqpCQ1 != null) {
			String b5rzxeAa = glnqpCQ1.substring(0, glnqpCQ1.lastIndexOf('/') + 1) + XbyRVmFy;
			try {
				URL nu76bNiM = new URL(b5rzxeAa);
				nu76bNiM.openConnection().connect();
				if (logger.isLoggable(Level.FINE)) {
					logger.fine("Resolve with help of baseURI to: " + b5rzxeAa);
				}
				QcvuM5uQ = new InputSource(b5rzxeAa);
				return new LSInputSAXWrapper(QcvuM5uQ);
			} catch (MalformedURLException MnV86rxz) {
			} catch (IOException iRjoDh8y) {
			}
		}
		if (logger.isLoggable(Level.WARNING)) {
			logger.warning("Failed to resolve the resource with the public ID: " + FslCcff6 + ", system ID: " + XbyRVmFy
					+ " and baseURI " + glnqpCQ1 + ".");
		}
		return null;
	}

}