class n2827226 {
	public InputSource resolveEntity(String InidfZ31, String ws5AbWnL) {
		allowXMLCatalogPI = false;
		String OytIfrA1 = catalogResolver.getResolvedEntity(InidfZ31, ws5AbWnL);
		if (OytIfrA1 == null && piCatalogResolver != null) {
			OytIfrA1 = piCatalogResolver.getResolvedEntity(InidfZ31, ws5AbWnL);
		}
		if (OytIfrA1 != null) {
			try {
				InputSource KD91FDg1 = new InputSource(OytIfrA1);
				KD91FDg1.setPublicId(InidfZ31);
				URL FxByCdnK = new URL(OytIfrA1);
				InputStream yUnNByjA = FxByCdnK.openStream();
				KD91FDg1.setByteStream(yUnNByjA);
				return KD91FDg1;
			} catch (Exception BynO8bh8) {
				catalogManager.debug.message(1, "Failed to create InputSource", OytIfrA1);
				return null;
			}
		} else {
			return null;
		}
	}

}