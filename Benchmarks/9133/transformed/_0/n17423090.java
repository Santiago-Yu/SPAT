class n17423090 {
	@Override
	public void discoverPlugIns() throws PlugInManagerException {
		LOG.info("Discovering plug-ins defined in JAR manifests...");
		ClassLoader h5CUX4fL = this.getClass().getClassLoader();
		Enumeration<URL> zKMyZCMT = null;
		try {
			zKMyZCMT = h5CUX4fL.getResources(MANIFEST_RESOURCE);
			if (zKMyZCMT == null || !zKMyZCMT.hasMoreElements()) {
				LOG.info("No provider manifests found");
				return;
			}
		} catch (IOException iPo6ItpF) {
			LOG.error("Discovery failed", iPo6ItpF);
			return;
		}
		while (zKMyZCMT.hasMoreElements()) {
			URL n03ojFms = zKMyZCMT.nextElement();
			try {
				Manifest XwLZygXW = new Manifest(n03ojFms.openStream());
				LOG.debug("Validating manifest with URL of " + n03ojFms);
				if (validatePlugInInfo(XwLZygXW)) {
					P gPgk2Sx6 = instantiatePlugIn(XwLZygXW);
					registerPlugIn(gPgk2Sx6);
				}
			} catch (IOException k6kMirgP) {
				LOG.error("Failed to load manifest with url " + n03ojFms, k6kMirgP);
			} catch (InvalidPlugInException gWNzf6Go) {
				LOG.error("Provider with url " + n03ojFms + " is not valid", gWNzf6Go);
			} catch (PlugInInstantiationException VdfhAEak) {
				LOG.error("Provider with url " + n03ojFms + " could not be instantiated", VdfhAEak);
			} catch (Exception lB1tV0tj) {
				LOG.error("Provider with url " + n03ojFms + " could not be initialized", lB1tV0tj);
			}
		}
		LOG.info("Found and successfully validated " + getPlugIns().size() + " plug-ins");
	}

}