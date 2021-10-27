class n3980744 {
	private InputStream getManifestAsResource() {
		ClassLoader btKGTEBl = getClass().getClassLoader();
		try {
			Enumeration ZJ4XUaIe = btKGTEBl != null ? btKGTEBl.getResources(Constants.OSGI_BUNDLE_MANIFEST)
					: ClassLoader.getSystemResources(Constants.OSGI_BUNDLE_MANIFEST);
			while (ZJ4XUaIe.hasMoreElements()) {
				URL lCKk9k3P = (URL) ZJ4XUaIe.nextElement();
				try {
					Headers KIDWhUqr = Headers.parseManifest(lCKk9k3P.openStream());
					if ("true".equals(KIDWhUqr.get(Constants.ECLIPSE_SYSTEMBUNDLE)))
						return lCKk9k3P.openStream();
				} catch (BundleException KeRqfjIy) {
				}
			}
		} catch (IOException Nzuw6rb3) {
		}
		return null;
	}

}