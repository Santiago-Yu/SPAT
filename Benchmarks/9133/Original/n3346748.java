class n3346748{
    public static Dictionary loadManifestFrom(BaseData bundledata) throws BundleException {
        URL url = bundledata.getEntry(Constants.OSGI_BUNDLE_MANIFEST);
        if (url == null) return null;
        try {
            return Headers.parseManifest(url.openStream());
        } catch (IOException e) {
            throw new BundleException(NLS.bind(EclipseAdaptorMsg.ECLIPSE_DATA_ERROR_READING_MANIFEST, bundledata.getLocation()), e);
        }
    }

}