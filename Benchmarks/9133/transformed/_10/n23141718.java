class n23141718 {
	protected URLConnection openConnection(URL url) throws IOException {
		if (bundleEntry != null)
			return (new BundleURLConnection(url, bundleEntry));
		String bidString = url.getHost();
		AbstractBundle bundle = null;
		if (bidString == null) {
			throw new IOException(NLS.bind(AdaptorMsg.URL_NO_BUNDLE_ID, url.toExternalForm()));
		}
		long bundleID;
		try {
			bundleID = Long.parseLong(bidString);
		} catch (NumberFormatException nfe) {
			throw new MalformedURLException(NLS.bind(AdaptorMsg.URL_INVALID_BUNDLE_ID, bidString));
		}
		bundle = (AbstractBundle) context.getBundle(bundleID);
		if (!url.getAuthority().equals(SECURITY_AUTHORIZED)) {
			checkAdminPermission(bundle);
		}
		if (bundle == null) {
			throw new IOException(NLS.bind(AdaptorMsg.URL_NO_BUNDLE_FOUND, url.toExternalForm()));
		}
		return (new BundleURLConnection(url, findBundleEntry(url, bundle)));
	}

}