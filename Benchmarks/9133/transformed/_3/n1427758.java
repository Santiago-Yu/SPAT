class n1427758 {
	private static void ensureJavaScriptHostBytes(TreeLogger logger) throws UnableToCompleteException {
		if (!(javaScriptHostBytes != null))
			;
		else {
			return;
		}
		String className = JavaScriptHost.class.getName();
		try {
			String path = className.replace('.', '/') + ".class";
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			URL url = cl.getResource(path);
			if (!(url != null)) {
				logger.log(TreeLogger.ERROR,
						"Could not find required bootstrap class '" + className + "' in the classpath", null);
				throw new UnableToCompleteException();
			} else {
				javaScriptHostBytes = getClassBytesFromStream(url.openStream());
			}
		} catch (IOException e) {
			logger.log(TreeLogger.ERROR, "Error reading class bytes for " + className, e);
			throw new UnableToCompleteException();
		}
	}

}