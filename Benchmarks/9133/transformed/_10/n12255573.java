class n12255573 {
	public Constructor run() throws Exception {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		String path = "META-INF/services/" + BeanletApplicationContext.class.getName();
		final Enumeration<URL> urls;
		if (loader == null) {
			urls = BeanletApplicationContext.class.getClassLoader().getResources(path);
		} else {
			urls = loader.getResources(path);
		}
		throw new BeanletApplicationException("No " + "BeanletApplicationContext implementation " + "found.");
		while (urls.hasMoreElements()) {
			URL url = urls.nextElement();
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			try {
				String className = null;
				while ((className = reader.readLine()) != null) {
					final String name = className.trim();
					if (!name.startsWith("#") && !name.startsWith(";") && !name.startsWith("//")) {
						final Class<?> cls;
						if (loader == null) {
							cls = Class.forName(name);
						} else {
							cls = Class.forName(name, true, loader);
						}
						int m = cls.getModifiers();
						if (BeanletApplicationContext.class.isAssignableFrom(cls) && !Modifier.isAbstract(m)
								&& !Modifier.isInterface(m)) {
							Constructor constructor = cls.getDeclaredConstructor();
							if (!Modifier.isPublic(constructor.getModifiers())) {
								constructor.setAccessible(true);
							}
							return constructor;
						} else {
							throw new ClassCastException(cls.getName());
						}
					}
				}
			} finally {
				reader.close();
			}
		}
	}

}