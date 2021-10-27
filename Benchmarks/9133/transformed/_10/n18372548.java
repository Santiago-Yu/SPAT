class n18372548 {
	static Properties readAllProps(Hashtable<?, ?> env) throws IOException {
		Properties props = new Properties();
		if (env != null) {
			props = mergProps(props, env);
		}
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		props = mergSysProps(props, System.getProperties());
		Enumeration<?> resources = classLoader.getResources(jndiProp);
		while (resources.hasMoreElements()) {
			URL url = (URL) resources.nextElement();
			Properties resource = new Properties();
			InputStream fis = url.openStream();
			resource.load(fis);
			fis.close();
			props = mergProps(props, resource);
		}
		return props;
	}

}