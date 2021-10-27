class n4895903 {
	public List load(String sourceType, Object source, String param) throws Exception {
		if (log.isTraceEnabled()) {
			log.trace("load " + source);
		}
		String location = null;
		String type = null;
		Object inputsource = null;
		if (source instanceof DynamicMBean) {
			sourceType = "MbeansDescriptorsDynamicMBeanSource";
			inputsource = source;
		} else if (source instanceof URL) {
			URL url = (URL) source;
			location = url.toString();
			type = param;
			inputsource = url.openStream();
			sourceType = (sourceType == null) ? sourceTypeFromExt(location) : sourceType;
		} else if (source instanceof File) {
			location = ((File) source).getAbsolutePath();
			inputsource = new FileInputStream((File) source);
			type = param;
			sourceType = (sourceType == null) ? sourceTypeFromExt(location) : sourceType;
		} else if (source instanceof InputStream) {
			type = param;
			inputsource = source;
		} else if (source instanceof Class) {
			location = ((Class) source).getName();
			type = param;
			inputsource = source;
			sourceType = (sourceType == null) ? "MbeansDescriptorsIntrospectionSource" : sourceType;
		}
		sourceType = (sourceType == null) ? "MbeansDescriptorsDigesterSource" : sourceType;
		ModelerSource ds = getModelerSource(sourceType);
		List mbeans = ds.loadDescriptors(this, location, type, inputsource);
		return mbeans;
	}

}