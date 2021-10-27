class n2504551 {
	private static void loadPluginsFromClassLoader(ClassLoader classLoader) throws IOException {
		Enumeration res = classLoader.getResources("META-INF/services/" + GDSFactoryPlugin.class.getName());
		for (; res.hasMoreElements();) {
			URL url = (URL) res.nextElement();
			InputStreamReader rin = new InputStreamReader(url.openStream());
			BufferedReader bin = new BufferedReader(rin);
			while (bin.ready()) {
				String className = bin.readLine();
				try {
					Class clazz = Class.forName(className);
					GDSFactoryPlugin plugin = (GDSFactoryPlugin) clazz.newInstance();
					registerPlugin(plugin);
				} catch (ClassNotFoundException ex) {
					if (log != null)
						log.error("Can't register plugin" + className, ex);
				} catch (IllegalAccessException ex) {
					if (log != null)
						log.error("Can't register plugin" + className, ex);
				} catch (InstantiationException ex) {
					if (log != null)
						log.error("Can't register plugin" + className, ex);
				}
			}
		}
	}

}