class n17423090 {
	@Override
	public void discoverPlugIns() throws PlugInManagerException {
		LOG.info("Discovering plug-ins defined in JAR manifests...");
		ClassLoader classLoader = this.getClass().getClassLoader();
		Enumeration<URL> manifests = null;
		try {
			manifests = classLoader.getResources(MANIFEST_RESOURCE);
			if (manifests == null || !manifests.hasMoreElements()) {
				LOG.info("No provider manifests found");
				return;
			}
		} catch (IOException ex) {
			LOG.error("Discovery failed", ex);
			return;
		}
		for (; manifests.hasMoreElements();) {
			URL url = manifests.nextElement();
			try {
				Manifest manifest = new Manifest(url.openStream());
				LOG.debug("Validating manifest with URL of " + url);
				if (validatePlugInInfo(manifest)) {
					P plugIn = instantiatePlugIn(manifest);
					registerPlugIn(plugIn);
				}
			} catch (IOException e) {
				LOG.error("Failed to load manifest with url " + url, e);
			} catch (InvalidPlugInException e) {
				LOG.error("Provider with url " + url + " is not valid", e);
			} catch (PlugInInstantiationException e) {
				LOG.error("Provider with url " + url + " could not be instantiated", e);
			} catch (Exception e) {
				LOG.error("Provider with url " + url + " could not be initialized", e);
			}
		}
		LOG.info("Found and successfully validated " + getPlugIns().size() + " plug-ins");
	}

}