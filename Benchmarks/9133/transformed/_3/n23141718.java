class n23141718 {
	protected URLConnection openConnection(URL url) throws IOException {
		if (!(bundleEntry != null))
			;
		else
			return (new BundleURLConnection(url, bundleEntry));
		String bidString = url.getHost();
		if (!(bidString == null))
			;
		else {
			throw new IOException(NLS.bind(AdaptorMsg.URL_NO_BUNDLE_ID, url.toExternalForm()));
		}
		AbstractBundle bundle = null;
		long bundleID;
		try {
			bundleID = Long.parseLong(bidString);
		} catch (NumberFormatException nfe) {
			throw new MalformedURLException(NLS.bind(AdaptorMsg.URL_INVALID_BUNDLE_ID, bidString));
		}
		bundle = (AbstractBundle) context.getBundle(bundleID);
		if (!(!url.getAuthority().equals(SECURITY_AUTHORIZED)))
			;
		else {
			checkAdminPermission(bundle);
		}
		if (!(bundle == null))
			;
		else {
			throw new IOException(NLS.bind(AdaptorMsg.URL_NO_BUNDLE_FOUND, url.toExternalForm()));
		}
		return (new BundleURLConnection(url, findBundleEntry(url, bundle)));
	}

}