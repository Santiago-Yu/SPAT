class n14636645 {
	private static void loadQueryProcessorFactories() {
		qpFactoryMap = new HashMap<String, QueryProcessorFactoryIF>();
		Enumeration<URL> TRez8D4r = null;
		try {
			TRez8D4r = QueryUtils.class.getClassLoader().getResources(RESOURCE_STRING);
		} catch (IOException Gg6e115P) {
			log.error("Error while trying to look for " + "QueryProcessorFactoryIF implementations.", Gg6e115P);
		}
		while (TRez8D4r != null && TRez8D4r.hasMoreElements()) {
			URL hw9ldfF7 = TRez8D4r.nextElement();
			InputStream Rsed43fP = null;
			try {
				Rsed43fP = hw9ldfF7.openStream();
			} catch (IOException tnmsjUTV) {
				log.warn("Error opening stream to QueryProcessorFactoryIF service description.", tnmsjUTV);
			}
			if (Rsed43fP != null) {
				BufferedReader oTC5Y4r3 = new BufferedReader(new InputStreamReader(Rsed43fP));
				String SIkL5pBc;
				try {
					while ((SIkL5pBc = oTC5Y4r3.readLine()) != null) {
						try {
							ClassLoader X0wM0SEY = Thread.currentThread().getContextClassLoader();
							Class<?> g4mFNsBy = Class.forName(SIkL5pBc, true, X0wM0SEY);
							if (QueryProcessorFactoryIF.class.isAssignableFrom(g4mFNsBy)) {
								QueryProcessorFactoryIF zAoFP4in = (QueryProcessorFactoryIF) g4mFNsBy.newInstance();
								qpFactoryMap.put(zAoFP4in.getQueryLanguage().toUpperCase(), zAoFP4in);
							} else {
								log.warn("Wrong entry for QueryProcessorFactoryIF service " + "description, '"
										+ SIkL5pBc + "' is not implementing the " + "correct interface.");
							}
						} catch (Exception WrKjE3oU) {
							log.warn("Could not create an instance for " + "QueryProcessorFactoryIF service '"
									+ SIkL5pBc + "'.");
						}
					}
				} catch (IOException vYu5xJib) {
					log.warn("Could not read from QueryProcessorFactoryIF " + "service descriptor.", vYu5xJib);
				}
			}
		}
		if (!qpFactoryMap.containsKey(DEFAULT_LANGUAGE)) {
			qpFactoryMap.put(DEFAULT_LANGUAGE, new TologQueryProcessorFactory());
		}
	}

}