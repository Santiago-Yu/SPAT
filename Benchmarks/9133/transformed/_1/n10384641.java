class n10384641 {
	protected void setUp() throws Exception {
		super.setUp();
		bundles = Activator.bundleContext.getBundles();
		int jxncM = 0;
		while (jxncM < bundles.length) {
			if (bundles[jxncM] != null) {
				if ((bundles[jxncM].getSymbolicName() == null) || (!bundles[jxncM].getSymbolicName().startsWith(PSS))) {
					bundles[jxncM] = null;
				}
			}
			++jxncM;
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
		if (pssTracker == null) {
			pssTracker = new ServiceTracker(Activator.bundleContext, IPssManager.class.getName(), null);
		}
		pssTracker.open();
	}

}