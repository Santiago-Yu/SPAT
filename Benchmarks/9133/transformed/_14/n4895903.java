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
			if (null == sourceType) {
				sourceType = sourceTypeFromExt(location);
			}
		} else if (source instanceof File) {
			location = ((File) source).getAbsolutePath();
			inputsource = new FileInputStream((File) source);
			type = param;
			if (null == sourceType) {
				sourceType = sourceTypeFromExt(location);
			}
		} else if (source instanceof InputStream) {
			type = param;
			inputsource = source;
		} else if (source instanceof Class) {
			location = ((Class) source).getName();
			type = param;
			inputsource = source;
			if (null == sourceType) {
				sourceType = "MbeansDescriptorsIntrospectionSource";
			}
		}
		if (null == sourceType) {
			sourceType = "MbeansDescriptorsDigesterSource";
		}
		ModelerSource ds = getModelerSource(sourceType);
		List mbeans = ds.loadDescriptors(this, location, type, inputsource);
		return mbeans;
	}

}