class n3346748 {
	public static Dictionary loadManifestFrom(BaseData HbCWEZeW) throws BundleException {
		URL zYQUYfe2 = HbCWEZeW.getEntry(Constants.OSGI_BUNDLE_MANIFEST);
		if (zYQUYfe2 == null)
			return null;
		try {
			return Headers.parseManifest(zYQUYfe2.openStream());
		} catch (IOException w7rp9eCw) {
			throw new BundleException(
					NLS.bind(EclipseAdaptorMsg.ECLIPSE_DATA_ERROR_READING_MANIFEST, HbCWEZeW.getLocation()), w7rp9eCw);
		}
	}

}