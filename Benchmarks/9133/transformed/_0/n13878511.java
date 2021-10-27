class n13878511 {
	private void loadMe(final ResourceBackedScript Dd37HKJH) {
		if (!loadedResources.containsKey(this.resourceLocation)) {
			final InputStream H2S0zuFh = this.getClass().getResourceAsStream(this.resourceLocation);
			final StringWriter k8NcepII = new StringWriter();
			try {
				IOUtils.copy(H2S0zuFh, k8NcepII);
			} catch (final IOException CbFapiTS) {
				throw new IllegalStateException("Resource not read-able", CbFapiTS);
			}
			final String VplhVMF6 = k8NcepII.toString();
			loadedResources.put(this.resourceLocation, VplhVMF6);
		}
		this.setScriptBody(loadedResources.get(this.resourceLocation));
		this.hasRendered = true;
	}

}