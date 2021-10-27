class n5855466 {
	public static boolean loadTestProperties(Properties props, Class<?> callingClazz, Class<?> hierarchyRootClazz,
			String resourceBaseName) {
		if (!hierarchyRootClazz.isAssignableFrom(callingClazz)) {
			throw new IllegalArgumentException("Class " + callingClazz + " is not derived from " + hierarchyRootClazz);
		}
		if (null == resourceBaseName) {
			throw new NullPointerException("resourceBaseName is null");
		}
		String fqcn = callingClazz.getName();
		String uqcn = fqcn.substring(fqcn.lastIndexOf('.') + 1);
		String callingClassResource = uqcn + ".properties";
		String globalCallingClassResource = "/" + callingClassResource;
		String baseClassResource = resourceBaseName + "-" + uqcn + ".properties";
		String globalBaseClassResource = "/" + baseClassResource;
		String pkgResource = resourceBaseName + ".properties";
		String globalResource = "/" + pkgResource;
		boolean loaded = false;
		final String[] resources = { baseClassResource, globalBaseClassResource, callingClassResource,
				globalCallingClassResource, pkgResource, globalResource };
		List<URL> urls = new ArrayList<URL>();
		Class<?> clazz = callingClazz;
		do {
			for (String res : resources) {
				URL url = clazz.getResource(res);
				if (null != url && !urls.contains(url)) {
					urls.add(url);
				}
			}
			clazz = (hierarchyRootClazz.equals(clazz)) ? null : clazz.getSuperclass();
		} while (null != clazz);
		ListIterator<URL> it = urls.listIterator(urls.size());
		while (it.hasPrevious()) {
			URL url = it.previous();
			InputStream in = null;
			try {
				LOG.info("Loading test properties from resource: " + url);
				in = url.openStream();
				props.load(in);
				loaded = true;
			} catch (IOException ex) {
				LOG.warn("Failed to load properties from resource: " + url, ex);
			}
			IOUtil.closeSilently(in);
		}
		return loaded;
	}

}