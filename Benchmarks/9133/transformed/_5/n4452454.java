class n4452454 {
	private InputStream getManifestAsResource() {
		ClassLoader cl = getClass().getClassLoader();
		try {
			Enumeration manifests;
			if (cl != null)
				manifests = cl.getResources(Constants.OSGI_BUNDLE_MANIFEST);
			else
				manifests = ClassLoader.getSystemResources(Constants.OSGI_BUNDLE_MANIFEST);
			while (manifests.hasMoreElements()) {
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