class n4895903 {
	public List load(String sourceType, Object source, String param) throws Exception {
		String location = null;
		if (log.isTraceEnabled()) {
			log.trace("load " + source);
		}
		Object inputsource = null;
		String type = null;
		if (source instanceof DynamicMBean) {
			inputsource = source;
			sourceType = "MbeansDescriptorsDynamicMBeanSource";
		} else if (source instanceof URL) {
			URL url = (URL) source;
			type = param;
			location = url.toString();
			inputsource = url.openStream();
			if (sourceType == null) {
				sourceType = sourceTypeFromExt(location);
			}
		} else if (source instanceof File) {
			location = ((File) source).getAbsolutePath();
			type = param;
			inputsource = new FileInputStream((File) source);
			if (sourceType == null) {
				sourceType = sourceTypeFromExt(location);
			}
		} else if (source instanceof InputStream) {
			inputsource = source;
			type = param;
		} else if (source instanceof Class) {
			type = param;
			location = ((Class) source).getName();
			if (sourceType == null) {
				sourceType = "MbeansDescriptorsIntrospectionSource";
			}
			inputsource = source;
		}
		if (sourceType == null) {
			sourceType = "MbeansDescriptorsDigesterSource";
		}
		ModelerSource ds = getModelerSource(sourceType);
		List mbeans = ds.loadDescriptors(this, location, type, inputsource);
		return mbeans;
	}

}