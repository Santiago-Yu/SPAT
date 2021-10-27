class n1427758 {
	private static void ensureJavaScriptHostBytes(TreeLogger BZgeLe1O) throws UnableToCompleteException {
		if (javaScriptHostBytes != null) {
			return;
		}
		String NxBZk6Ok = JavaScriptHost.class.getName();
		try {
			String WLYMQGsD = NxBZk6Ok.replace('.', '/') + ".class";
			ClassLoader VabyJbWm = Thread.currentThread().getContextClassLoader();
			URL ieNeljQD = VabyJbWm.getResource(WLYMQGsD);
			if (ieNeljQD != null) {
				javaScriptHostBytes = getClassBytesFromStream(ieNeljQD.openStream());
			} else {
				BZgeLe1O.log(TreeLogger.ERROR,
						"Could not find required bootstrap class '" + NxBZk6Ok + "' in the classpath", null);
				throw new UnableToCompleteException();
			}
		} catch (IOException JnwMOFX8) {
			BZgeLe1O.log(TreeLogger.ERROR, "Error reading class bytes for " + NxBZk6Ok, JnwMOFX8);
			throw new UnableToCompleteException();
		}
	}

}