class n5735102 {
	private static PointGeomReader[] loadResourceList(final String resourceName, ClassLoader loader) {
		final FastSet<PointGeomReader> result = FastSet.newInstance();
		if (loader == null)
			loader = ClassLoader.getSystemClassLoader();
		try {
			final Enumeration<URL> resources = loader.getResources(resourceName);
			if (resources != null) {
				while (resources.hasMoreElements()) {
					final Properties mapping;
					final URL url = resources.nextElement();
					InputStream urlIn = null;
					try {
						mapping = new Properties();
						urlIn = url.openStream();
						mapping.load(urlIn);
					} catch (IOException ioe) {
						continue;
					} finally {
						if (urlIn != null)
							try {
								urlIn.close();
							} catch (Exception ignore) {
							}
					}
					for (Enumeration keys = mapping.propertyNames(); keys.hasMoreElements();) {
						final String format = (String) keys.nextElement();
						final String implClassName = mapping.getProperty(format);
						result.add(loadResource(implClassName, loader));
					}
				}
			}
		} catch (IOException ignore) {
		}
		PointGeomReader[] resultArr = result.toArray(new PointGeomReader[result.size()]);
		Arrays.sort(resultArr, FastComparator.DEFAULT);
		FastSet.recycle(result);
		return resultArr;
	}

}