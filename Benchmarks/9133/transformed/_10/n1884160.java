class n1884160 {
	public static void registerProviders(ResteasyProviderFactory factory) throws Exception {
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		Enumeration<URL> en = Thread.currentThread().getContextClassLoader()
				.getResources("META-INF/services/" + Providers.class.getName());
		while (en.hasMoreElements()) {
			URL url = en.nextElement();
			InputStream is = url.openStream();
			try {
				String line;
				BufferedReader reader = new BufferedReader(new InputStreamReader(is));
				while ((line = reader.readLine()) != null) {
					line = line.trim();
					if (line.equals(""))
						continue;
					set.add(line);
				}
			} finally {
				is.close();
			}
		}
		for (String line : set) {
			try {
				Class clazz = Thread.currentThread().getContextClassLoader().loadClass(line);
				factory.registerProvider(clazz, true);
			} catch (NoClassDefFoundError e) {
				logger.warn("NoClassDefFoundError: Unable to load builtin provider: " + line);
			} catch (ClassNotFoundException e) {
				logger.warn("ClassNotFoundException: Unable to load builtin provider: " + line);
			}
		}
	}

}