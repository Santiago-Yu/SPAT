class n10384641 {
	protected void setUp() throws Exception {
		super.setUp();
		bundles = Activator.bundleContext.getBundles();
		for (int i = 0; i < bundles.length; ++i) {
			if (bundles[i] != null) {
				if ((bundles[i].getSymbolicName() == null) || (!bundles[i].getSymbolicName().startsWith(PSS))) {
					bundles[i] = null;
				}
			}
		}
		checklist = new Properties();
		try {
			URL url = Activator.bundleContext.getBundle().getResource(CHECK_FILE);
			InputStream is = new BufferedInputStream(url.openStream());
			checklist.load(is);
			is.close();
		} catch (FileNotFoundException fe) {
			fail("Failed to find service checklist file");
		} catch (IOException e) {
			fail("Failed to load service checklist file");
		}
		pssTracker = (pssTracker == null)
				? new ServiceTracker(Activator.bundleContext, IPssManager.class.getName(), null)
				: pssTracker;
		pssTracker.open();
	}

}