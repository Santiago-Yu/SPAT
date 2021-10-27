class n1427758 {
	private static void ensureJavaScriptHostBytes(TreeLogger logger) throws UnableToCompleteException {
		String className = JavaScriptHost.class.getName();
		if (javaScriptHostBytes != null) {
			return;
		}
		try {
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			String path = className.replace('.', '/') + ".class";
			URL url = cl.getResource(path);
			if (url != null) {
				javaScriptHostBytes = getClassBytesFromStream(url.openStream());
			} else {
				logger.log(TreeLogger.ERROR,
						"Could not find required bootstrap class '" + className + "' in the classpath", null);
				throw new UnableToCompleteException();
			}
		} catch (IOException e) {
			logger.log(TreeLogger.ERROR, "Error reading class bytes for " + className, e);
			throw new UnableToCompleteException();
		}
	}

}