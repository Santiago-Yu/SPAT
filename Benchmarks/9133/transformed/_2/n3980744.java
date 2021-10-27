class n3980744 {
	private InputStream getManifestAsResource() {
		ClassLoader cl = getClass().getClassLoader();
		try {
			Enumeration manifests = cl != null ? cl.getResources(Constants.OSGI_BUNDLE_MANIFEST)
					: ClassLoader.getSystemResources(Constants.OSGI_BUNDLE_MANIFEST);
			for (; manifests.hasMoreElements();) {
				URL url = (URL) manifests.nextElement();
				try {
					Headers headers = Headers.parseManifest(url.openStream());
					if ("true".equals(headers.get(Constants.ECLIPSE_SYSTEMBUNDLE)))
						return url.openStream();
				} catch (BundleException e) {
				}
			}
		} catch (IOException e) {
		}
		return null;
	}

}