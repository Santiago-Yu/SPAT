class n5247455 {
	private static void findAllProviders() {
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			Enumeration<URL> resources = loader
					.getResources("META-INF/services/" + PersistenceProvider.class.getName());
			Set<String> names = new HashSet<String>();
			for (; resources.hasMoreElements();) {
				URL url = resources.nextElement();
				InputStream is = url.openStream();
				try {
					names.addAll(providerNamesFromReader(new BufferedReader(new InputStreamReader(is))));
				} finally {
					is.close();
				}
			}
			for (String s : names) {
				Class providerClass = loader.loadClass(s);
				providers.add((PersistenceProvider) providerClass.newInstance());
			}
		} catch (IOException e) {
			throw new PersistenceException(e);
		} catch (InstantiationException e) {
			throw new PersistenceException(e);
		} catch (IllegalAccessException e) {
			throw new PersistenceException(e);
		} catch (ClassNotFoundException e) {
			throw new PersistenceException(e);
		}
	}

}