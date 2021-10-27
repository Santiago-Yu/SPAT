class n1944490 {
	protected PersistenceUnitInfo getPersistenceUnitInfo() {
		if (null == this.persistenceUnitInfo) {
			this.persistenceUnitInfo = new PersistenceUnitInfo() {

				private List<ClassTransformer> transformers;

				private List<String> managedClasses;

				private List<String> mappingFileNames;

				private ClassLoader classLoader;

				public String getPersistenceUnitName() {
					return "jomc-standalone";
				}

				public String getPersistenceProviderClassName() {
					return getPersistenceProvider().getClass().getName();
				}

				public PersistenceUnitTransactionType getTransactionType() {
					return PersistenceUnitTransactionType.JTA;
				}

				public DataSource getJtaDataSource() {
					try {
						return (DataSource) getContext().lookup(getEnvironment().getJtaDataSourceJndiName());
					} catch (final NamingException e) {
						getLogger().fatal(e);
						throw new RuntimeException(e);
					}
				}

				public DataSource getNonJtaDataSource() {
					return null;
				}

				public List<String> getMappingFileNames() {
					try {
						if (null == this.mappingFileNames) {
							this.mappingFileNames = new LinkedList<String>();
							final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
							factory.setNamespaceAware(true);
							factory.setValidating(false);
							final DocumentBuilder documentBuilder = factory.newDocumentBuilder();
							for (final Enumeration<URL> e = this.getNewTempClassLoader()
									.getResources("META-INF/persistence.xml"); e.hasMoreElements();) {
								final URL url = e.nextElement();
								final InputStream in = url.openStream();
								final Document doc = documentBuilder.parse(in);
								in.close();
								final NodeList persistenceUnits = doc.getElementsByTagNameNS(PERSISTENCE_NS,
										"persistence-unit");
								for (int i = persistenceUnits.getLength() - 1; i >= 0; i--) {
									final Element persistenceUnit = (Element) persistenceUnits.item(i);
									final NodeList mappingFiles = persistenceUnit.getElementsByTagNameNS(PERSISTENCE_NS,
											"mapping-file");
									for (int j = mappingFiles.getLength() - 1; j >= 0; j--) {
										final Element mappingFile = (Element) mappingFiles.item(j);
										this.mappingFileNames.add(mappingFile.getFirstChild().getNodeValue());
									}
								}
							}
						}
						return this.mappingFileNames;
					} catch (final SAXException e) {
						getLogger().fatal(e);
						throw new RuntimeException(e);
					} catch (final IOException e) {
						getLogger().fatal(e);
						throw new RuntimeException(e);
					} catch (final ParserConfigurationException e) {
						getLogger().fatal(e);
						throw new RuntimeException(e);
					}
				}

				public List<URL> getJarFileUrls() {
					try {
						final List<URL> jarFileUrls = new LinkedList<URL>();
						for (final Enumeration<URL> unitUrls = this.getClassLoader()
								.getResources("META-INF/persistence.xml"); unitUrls.hasMoreElements();) {
							final URL unitUrl = unitUrls.nextElement();
							final String externalForm = unitUrl.toExternalForm();
							final String jarUrl = externalForm.substring(0, externalForm.indexOf("META-INF"));
							jarFileUrls.add(new URL(jarUrl));
						}
						return jarFileUrls;
					} catch (final IOException e) {
						getLogger().fatal(e);
						throw new RuntimeException(e.getMessage(), e);
					}
				}

				public URL getPersistenceUnitRootUrl() {
					return getEnvironment().getJpaRootUrl();
				}

				public List<String> getManagedClassNames() {
					try {
						if (null == this.managedClasses) {
							this.managedClasses = new LinkedList<String>();
							final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
							factory.setNamespaceAware(true);
							factory.setValidating(false);
							final DocumentBuilder documentBuilder = factory.newDocumentBuilder();
							for (final Enumeration<URL> e = this.getNewTempClassLoader()
									.getResources("META-INF/persistence.xml"); e.hasMoreElements();) {
								final URL url = e.nextElement();
								final InputStream in = url.openStream();
								final Document doc = documentBuilder.parse(in);
								in.close();
								final NodeList persistenceUnits = doc.getElementsByTagNameNS(PERSISTENCE_NS,
										"persistence-unit");
								for (int i = persistenceUnits.getLength() - 1; i >= 0; i--) {
									final Element persistenceUnit = (Element) persistenceUnits.item(i);
									final NodeList classes = persistenceUnit.getElementsByTagNameNS(PERSISTENCE_NS,
											"class");
									for (int j = classes.getLength() - 1; j >= 0; j--) {
										final Element clazz = (Element) classes.item(j);
										this.managedClasses.add(clazz.getFirstChild().getNodeValue());
									}
								}
							}
						}
						return this.managedClasses;
					} catch (final SAXException e) {
						getLogger().fatal(e);
						throw new RuntimeException(e);
					} catch (final IOException e) {
						getLogger().fatal(e);
						throw new RuntimeException(e);
					} catch (final ParserConfigurationException e) {
						getLogger().fatal(e);
						throw new RuntimeException(e);
					}
				}

				public boolean excludeUnlistedClasses() {
					return false;
				}

				public Properties getProperties() {
					return getEnvironment().getProperties();
				}

				public ClassLoader getClassLoader() {
					if (null == this.classLoader) {
						this.classLoader = this.getClass().getClassLoader();
						if (null == this.classLoader) {
							this.classLoader = ClassLoader.getSystemClassLoader();
						}
						this.classLoader = new URLClassLoader(new URL[] { getEnvironment().getJpaRootUrl() },
								this.classLoader);
					}
					return this.classLoader;
				}

				public void addTransformer(final ClassTransformer transformer) {
					if (null == this.transformers) {
						this.transformers = new LinkedList<ClassTransformer>();
					}
					this.transformers.add(transformer);
				}

				public ClassLoader getNewTempClassLoader() {
					final List<URL> jarFileUrls = this.getJarFileUrls();
					jarFileUrls.add(getEnvironment().getJpaRootUrl());
					return new URLClassLoader(jarFileUrls.toArray(new URL[jarFileUrls.size()]));
				}
			};
		}
		return this.persistenceUnitInfo;
	}

}