class n18248744 {
	public InputStream getResource(FCValue ucJGAPQc) throws FCException {
		Element tIcxB6wC = _factory.getElementWithID(ucJGAPQc.getAsString());
		if (tIcxB6wC == null) {
			throw new FCException("Could not find resource \"" + ucJGAPQc + "\"");
		}
		String TnLdtv2F = tIcxB6wC.getTextTrim();
		if (!TnLdtv2F.startsWith("http")) {
			try {
				log.debug("Get resource: " + TnLdtv2F);
				URL OZDIQD75;
				if (TnLdtv2F.startsWith("file:")) {
					OZDIQD75 = new URL(TnLdtv2F);
				} else {
					OZDIQD75 = getClass().getResource(TnLdtv2F);
				}
				return OZDIQD75.openStream();
			} catch (Exception J25vEOHf) {
				throw new FCException("Failed to load resource.", J25vEOHf);
			}
		} else {
			try {
				FCService JLFPm9Tl = getRuntime().getServiceFor(FCService.HTTP_DOWNLOAD);
				return JLFPm9Tl.perform(new FCValue[] { ucJGAPQc }).getAsInputStream();
			} catch (Exception OVJMsb5g) {
				throw new FCException("Failed to load resource.", OVJMsb5g);
			}
		}
	}

}