class n12198266 {
	private DataSource loadSingleDataSource(ClassLoader contextLoader, URL url)
			throws IOException, DataSourceException {
		URI datasourceURI;
		OWLOntology datasourceOntology = null;
		URL baseURL = new URL(url.toString().replace("META-INF/artifact.properties", ""));
		Properties properties = new Properties();
		properties.load(url.openStream());
		String fileName = properties.get("db").toString() + ".owl", pkg = properties.get("package").toString();
		datasourceURI = URI.create("http://" + properties.get("host").toString() + "/" + fileName);
		Set<Class> beans = new HashSet<Class>();
		if (baseURL.toString().startsWith("jar") && baseURL.toString().endsWith("!/")) {
			JarURLConnection jarConn = (JarURLConnection) baseURL.openConnection();
			Enumeration<JarEntry> entries = jarConn.getJarFile().entries();
			while (entries.hasMoreElements()) {
				JarEntry next = entries.nextElement();
				if (next.getName().startsWith(pkg.replace('.', '/')) && next.getName().endsWith(".class")) {
					String fullClassName = next.getName().replace('/', '.').replace(".class", "");
					try {
						beans.add(contextLoader.loadClass(fullClassName));
					} catch (ClassNotFoundException e) {
						throw new DataSourceException("Unable to locate " + fullClassName + ".class", e);
					}
				} else if (next.getName().equals(fileName)) {
					String resName = next.getName();
					URL owl = contextLoader.getResource(resName);
					try {
						datasourceOntology = OWLManager.createOWLOntologyManager()
								.loadOntologyFromPhysicalURI(owl.toURI());
					} catch (URISyntaxException e) {
						throw new DataSourceException("Bad syntax converting url -> uri: " + owl.toString(), e);
					} catch (OWLOntologyCreationException e) {
						throw new DataSourceException("Couldn't create ontology from " + owl.toString(), e);
					}
				}
			}
			if (beans.size() == 0) {
				throw new DataSourceException("Failed to load beans for the datasource at " + url);
			}
			if (datasourceOntology == null) {
				throw new DataSourceException(
						"The datasource at " + url + " contains no ontology, or the ontology could not be loaded");
			}
			return new BeanModelDataSource(datasourceURI, datasourceOntology);
		} else {
			throw new DataSourceException("Unable to create a datasource, cannot load classes with the "
					+ "given URL protocol (" + baseURL + ")");
		}
	}

}