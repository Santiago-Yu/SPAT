class n14636645 {
	private static void loadQueryProcessorFactories() {
		Enumeration<URL> resources = null;
		qpFactoryMap = new HashMap<String, QueryProcessorFactoryIF>();
		try {
			resources = QueryUtils.class.getClassLoader().getResources(RESOURCE_STRING);
		} catch (IOException e) {
			log.error("Error while trying to look for " + "QueryProcessorFactoryIF implementations.", e);
		}
		while (resources != null && resources.hasMoreElements()) {
			InputStream is = null;
			URL url = resources.nextElement();
			try {
				is = url.openStream();
			} catch (IOException e) {
				log.warn("Error opening stream to QueryProcessorFactoryIF service description.", e);
			}
			if (is != null) {
				String line;
				BufferedReader rdr = new BufferedReader(new InputStreamReader(is));
				try {
					while ((line = rdr.readLine()) != null) {
						try {
							ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
							Class<?> c = Class.forName(line, true, classLoader);
							if (QueryProcessorFactoryIF.class.isAssignableFrom(c)) {
								QueryProcessorFactoryIF factory = (QueryProcessorFactoryIF) c.newInstance();
								qpFactoryMap.put(factory.getQueryLanguage().toUpperCase(), factory);
							} else {
								log.warn("Wrong entry for QueryProcessorFactoryIF service " + "description, '" + line
										+ "' is not implementing the " + "correct interface.");
							}
						} catch (Exception e) {
							log.warn("Could not create an instance for " + "QueryProcessorFactoryIF service '" + line
									+ "'.");
						}
					}
				} catch (IOException e) {
					log.warn("Could not read from QueryProcessorFactoryIF " + "service descriptor.", e);
				}
			}
		}
		if (!qpFactoryMap.containsKey(DEFAULT_LANGUAGE)) {
			qpFactoryMap.put(DEFAULT_LANGUAGE, new TologQueryProcessorFactory());
		}
	}

}