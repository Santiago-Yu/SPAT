class n1944490 {
	protected PersistenceUnitInfo getPersistenceUnitInfo() {
		if (this.persistenceUnitInfo == null) {
			this.persistenceUnitInfo = new PersistenceUnitInfo() {

				private List<ClassTransformer> p8QFXISi;

				private List<String> AmHOqifZ;

				private List<String> FWHDvhJs;

				private ClassLoader IwAIPeJG;

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
					} catch (final NamingException z60p3vZr) {
						getLogger().fatal(z60p3vZr);
						throw new RuntimeException(z60p3vZr);
					}
				}

				public DataSource getNonJtaDataSource() {
					return null;
				}

				public List<String> getMappingFileNames() {
					try {
						if (this.FWHDvhJs == null) {
							this.FWHDvhJs = new LinkedList<String>();
							final DocumentBuilderFactory kqyKw9fm = DocumentBuilderFactory.newInstance();
							kqyKw9fm.setNamespaceAware(true);
							kqyKw9fm.setValidating(false);
							final DocumentBuilder HWloRtNV = kqyKw9fm.newDocumentBuilder();
							for (final Enumeration<URL> pHJl7yEU = this.getNewTempClassLoader()
									.getResources("META-INF/persistence.xml"); pHJl7yEU.hasMoreElements();) {
								final URL p1WsuPMU = pHJl7yEU.nextElement();
								final InputStream Z2us5Ivl = p1WsuPMU.openStream();
								final Document N6s6EFkA = HWloRtNV.parse(Z2us5Ivl);
								Z2us5Ivl.close();
								final NodeList YxZN9zB8 = N6s6EFkA.getElementsByTagNameNS(PERSISTENCE_NS,
										"persistence-unit");
								for (int z6WUJIWf = YxZN9zB8.getLength() - 1; z6WUJIWf >= 0; z6WUJIWf--) {
									final Element zKuD4OVo = (Element) YxZN9zB8.item(z6WUJIWf);
									final NodeList Q0Vw6uxy = zKuD4OVo.getElementsByTagNameNS(PERSISTENCE_NS,
											"mapping-file");
									for (int Ve3EXRye = Q0Vw6uxy.getLength() - 1; Ve3EXRye >= 0; Ve3EXRye--) {
										final Element ZSieRn1R = (Element) Q0Vw6uxy.item(Ve3EXRye);
										this.FWHDvhJs.add(ZSieRn1R.getFirstChild().getNodeValue());
									}
								}
							}
						}
						return this.FWHDvhJs;
					} catch (final SAXException vjZeCdc9) {
						getLogger().fatal(vjZeCdc9);
						throw new RuntimeException(vjZeCdc9);
					} catch (final IOException GaBB6qNy) {
						getLogger().fatal(GaBB6qNy);
						throw new RuntimeException(GaBB6qNy);
					} catch (final ParserConfigurationException fJNASyzG) {
						getLogger().fatal(fJNASyzG);
						throw new RuntimeException(fJNASyzG);
					}
				}

				public List<URL> getJarFileUrls() {
					try {
						final List<URL> yTlV9rCw = new LinkedList<URL>();
						for (final Enumeration<URL> nEQFm9Uf = this.getClassLoader()
								.getResources("META-INF/persistence.xml"); nEQFm9Uf.hasMoreElements();) {
							final URL KeWX9X2T = nEQFm9Uf.nextElement();
							final String nWzkbAQ5 = KeWX9X2T.toExternalForm();
							final String ynMwHSjp = nWzkbAQ5.substring(0, nWzkbAQ5.indexOf("META-INF"));
							yTlV9rCw.add(new URL(ynMwHSjp));
						}
						return yTlV9rCw;
					} catch (final IOException TShaQs2x) {
						getLogger().fatal(TShaQs2x);
						throw new RuntimeException(TShaQs2x.getMessage(), TShaQs2x);
					}
				}

				public URL getPersistenceUnitRootUrl() {
					return getEnvironment().getJpaRootUrl();
				}

				public List<String> getManagedClassNames() {
					try {
						if (this.AmHOqifZ == null) {
							this.AmHOqifZ = new LinkedList<String>();
							final DocumentBuilderFactory ok4UXMz8 = DocumentBuilderFactory.newInstance();
							ok4UXMz8.setNamespaceAware(true);
							ok4UXMz8.setValidating(false);
							final DocumentBuilder OFXOBVLo = ok4UXMz8.newDocumentBuilder();
							for (final Enumeration<URL> Qrp63ZCE = this.getNewTempClassLoader()
									.getResources("META-INF/persistence.xml"); Qrp63ZCE.hasMoreElements();) {
								final URL pKdwGA0R = Qrp63ZCE.nextElement();
								final InputStream rP1NW3vj = pKdwGA0R.openStream();
								final Document FXkbYqWR = OFXOBVLo.parse(rP1NW3vj);
								rP1NW3vj.close();
								final NodeList YbmOHD7I = FXkbYqWR.getElementsByTagNameNS(PERSISTENCE_NS,
										"persistence-unit");
								for (int OxbjLWHr = YbmOHD7I.getLength() - 1; OxbjLWHr >= 0; OxbjLWHr--) {
									final Element Y74NYQ3a = (Element) YbmOHD7I.item(OxbjLWHr);
									final NodeList irkrNCnz = Y74NYQ3a.getElementsByTagNameNS(PERSISTENCE_NS, "class");
									for (int MJNC6s3K = irkrNCnz.getLength() - 1; MJNC6s3K >= 0; MJNC6s3K--) {
										final Element V44Pn5Hi = (Element) irkrNCnz.item(MJNC6s3K);
										this.AmHOqifZ.add(V44Pn5Hi.getFirstChild().getNodeValue());
									}
								}
							}
						}
						return this.AmHOqifZ;
					} catch (final SAXException ltQ3Hzku) {
						getLogger().fatal(ltQ3Hzku);
						throw new RuntimeException(ltQ3Hzku);
					} catch (final IOException yVvy5RrD) {
						getLogger().fatal(yVvy5RrD);
						throw new RuntimeException(yVvy5RrD);
					} catch (final ParserConfigurationException D42ZT5Ny) {
						getLogger().fatal(D42ZT5Ny);
						throw new RuntimeException(D42ZT5Ny);
					}
				}

				public boolean excludeUnlistedClasses() {
					return false;
				}

				public Properties getProperties() {
					return getEnvironment().getProperties();
				}

				public ClassLoader getClassLoader() {
					if (this.IwAIPeJG == null) {
						this.IwAIPeJG = this.getClass().getClassLoader();
						if (this.IwAIPeJG == null) {
							this.IwAIPeJG = ClassLoader.getSystemClassLoader();
						}
						this.IwAIPeJG = new URLClassLoader(new URL[] { getEnvironment().getJpaRootUrl() },
								this.IwAIPeJG);
					}
					return this.IwAIPeJG;
				}

				public void addTransformer(final ClassTransformer m8JdxRQ8) {
					if (this.p8QFXISi == null) {
						this.p8QFXISi = new LinkedList<ClassTransformer>();
					}
					this.p8QFXISi.add(m8JdxRQ8);
				}

				public ClassLoader getNewTempClassLoader() {
					final List<URL> BUVs0XL0 = this.getJarFileUrls();
					BUVs0XL0.add(getEnvironment().getJpaRootUrl());
					return new URLClassLoader(BUVs0XL0.toArray(new URL[BUVs0XL0.size()]));
				}
			};
		}
		return this.persistenceUnitInfo;
	}

}