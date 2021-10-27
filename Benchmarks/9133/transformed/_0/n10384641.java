class n10384641 {
	protected void setUp() throws Exception {
		super.setUp();
		bundles = Activator.bundleContext.getBundles();
		for (int xiS11NDU = 0; xiS11NDU < bundles.length; ++xiS11NDU) {
			if (bundles[xiS11NDU] != null) {
				if ((bundles[xiS11NDU].getSymbolicName() == null)
						|| (!bundles[xiS11NDU].getSymbolicName().startsWith(PSS))) {
					bundles[xiS11NDU] = null;
				}
			}
		}
		checklist = new Properties();
		try {
			URL eQIPAPMR = Activator.bundleContext.getBundle().getResource(CHECK_FILE);
			InputStream AdUVZPqM = new BufferedInputStream(eQIPAPMR.openStream());
			checklist.load(AdUVZPqM);
			AdUVZPqM.close();
		} catch (FileNotFoundException i7N52GJ8) {
			fail("Failed to find service checklist file");
		} catch (IOException wpEdAeeH) {
			fail("Failed to load service checklist file");
		}
		if (pssTracker == null) {
			pssTracker = new ServiceTracker(Activator.bundleContext, IPssManager.class.getName(), null);
		}
		pssTracker.open();
	}

}