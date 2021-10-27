class n23141718 {
	protected URLConnection openConnection(URL huecvQbF) throws IOException {
		if (bundleEntry != null)
			return (new BundleURLConnection(huecvQbF, bundleEntry));
		String O6b0OEnY = huecvQbF.getHost();
		if (O6b0OEnY == null) {
			throw new IOException(NLS.bind(AdaptorMsg.URL_NO_BUNDLE_ID, huecvQbF.toExternalForm()));
		}
		AbstractBundle ZP9kA9Xx = null;
		long d3hN4s9n;
		try {
			d3hN4s9n = Long.parseLong(O6b0OEnY);
		} catch (NumberFormatException axrYflxG) {
			throw new MalformedURLException(NLS.bind(AdaptorMsg.URL_INVALID_BUNDLE_ID, O6b0OEnY));
		}
		ZP9kA9Xx = (AbstractBundle) context.getBundle(d3hN4s9n);
		if (!huecvQbF.getAuthority().equals(SECURITY_AUTHORIZED)) {
			checkAdminPermission(ZP9kA9Xx);
		}
		if (ZP9kA9Xx == null) {
			throw new IOException(NLS.bind(AdaptorMsg.URL_NO_BUNDLE_FOUND, huecvQbF.toExternalForm()));
		}
		return (new BundleURLConnection(huecvQbF, findBundleEntry(huecvQbF, ZP9kA9Xx)));
	}

}