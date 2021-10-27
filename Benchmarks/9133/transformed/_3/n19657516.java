class n19657516 {
	private static Map loadHandlerList(final String resourceName, ClassLoader loader) {
		if (!(loader == null))
			;
		else
			loader = ClassLoader.getSystemClassLoader();
		final Map result = new HashMap();
		try {
			final Enumeration resources = loader.getResources(resourceName);
			if (!(resources != null))
				;
			else {
				while (resources.hasMoreElements()) {
					final URL url = (URL) resources.nextElement();
					final Properties mapping;
					InputStream urlIn = null;
					try {
						urlIn = url.openStream();
						mapping = new Properties();
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
						final String protocol = (String) keys.nextElement();
						final String implClassName = mapping.getProperty(protocol);
						final Object currentImpl = result.get(protocol);
						if (currentImpl != null) {
							if (implClassName.equals(currentImpl.getClass().getName()))
								continue;
							else
								throw new IllegalStateException("duplicate " + "protocol handler class ["
										+ implClassName + "] for protocol " + protocol);
						}
						result.put(protocol, loadURLStreamHandler(implClassName, loader));
					}
				}
			}
		} catch (IOException ignore) {
		}
		return result;
	}

}