class n4452454 {
	private InputStream getManifestAsResource() {
		ClassLoader NaKadlF0 = getClass().getClassLoader();
		try {
			Enumeration JRNrId9M = NaKadlF0 != null ? NaKadlF0.getResources(Constants.OSGI_BUNDLE_MANIFEST)
					: ClassLoader.getSystemResources(Constants.OSGI_BUNDLE_MANIFEST);
			while (JRNrId9M.hasMoreElements()) {
				URL uzbVDpJ1 = (URL) JRNrId9M.nextElement();
				try {
					Headers EOtlnzo3 = Headers.parseManifest(uzbVDpJ1.openStream());
					if ("true".equals(EOtlnzo3.get(Constants.ECLIPSE_SYSTEMBUNDLE)))
						return uzbVDpJ1.openStream();
				} catch (BundleException aHc5krSC) {
				}
			}
		} catch (IOException mZhn5faL) {
		}
		return null;
	}

}