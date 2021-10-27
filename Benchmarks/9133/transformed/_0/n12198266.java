class n12198266 {
	private DataSource loadSingleDataSource(ClassLoader XYhGWQWp, URL xHOaqL0d)
			throws IOException, DataSourceException {
		URI VYrYZP6x;
		OWLOntology ti8h9ajE = null;
		URL aYdU3ibY = new URL(xHOaqL0d.toString().replace("META-INF/artifact.properties", ""));
		Properties igOqcUAh = new Properties();
		igOqcUAh.load(xHOaqL0d.openStream());
		String kWYYwCiD = igOqcUAh.get("db").toString() + ".owl";
		String qBHU28rn = igOqcUAh.get("package").toString();
		VYrYZP6x = URI.create("http://" + igOqcUAh.get("host").toString() + "/" + kWYYwCiD);
		Set<Class> NS5QwXUW = new HashSet<Class>();
		if (aYdU3ibY.toString().startsWith("jar") && aYdU3ibY.toString().endsWith("!/")) {
			JarURLConnection jw8nMMGn = (JarURLConnection) aYdU3ibY.openConnection();
			Enumeration<JarEntry> vXPJacyl = jw8nMMGn.getJarFile().entries();
			while (vXPJacyl.hasMoreElements()) {
				JarEntry LGRvhnOo = vXPJacyl.nextElement();
				if (LGRvhnOo.getName().startsWith(qBHU28rn.replace('.', '/'))
						&& LGRvhnOo.getName().endsWith(".class")) {
					String UzLwwsYc = LGRvhnOo.getName().replace('/', '.').replace(".class", "");
					try {
						NS5QwXUW.add(XYhGWQWp.loadClass(UzLwwsYc));
					} catch (ClassNotFoundException Px3bN1qX) {
						throw new DataSourceException("Unable to locate " + UzLwwsYc + ".class", Px3bN1qX);
					}
				} else if (LGRvhnOo.getName().equals(kWYYwCiD)) {
					String C7vELZhv = LGRvhnOo.getName();
					URL vyA2Ynp7 = XYhGWQWp.getResource(C7vELZhv);
					try {
						ti8h9ajE = OWLManager.createOWLOntologyManager().loadOntologyFromPhysicalURI(vyA2Ynp7.toURI());
					} catch (URISyntaxException Gr3JuCvM) {
						throw new DataSourceException("Bad syntax converting url -> uri: " + vyA2Ynp7.toString(),
								Gr3JuCvM);
					} catch (OWLOntologyCreationException Fa5lTXqi) {
						throw new DataSourceException("Couldn't create ontology from " + vyA2Ynp7.toString(), Fa5lTXqi);
					}
				}
			}
			if (NS5QwXUW.size() == 0) {
				throw new DataSourceException("Failed to load beans for the datasource at " + xHOaqL0d);
			}
			if (ti8h9ajE == null) {
				throw new DataSourceException(
						"The datasource at " + xHOaqL0d + " contains no ontology, or the ontology could not be loaded");
			}
			return new BeanModelDataSource(VYrYZP6x, ti8h9ajE);
		} else {
			throw new DataSourceException("Unable to create a datasource, cannot load classes with the "
					+ "given URL protocol (" + aYdU3ibY + ")");
		}
	}

}