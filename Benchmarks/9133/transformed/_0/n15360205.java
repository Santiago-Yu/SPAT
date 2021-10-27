class n15360205 {
	private static void initMimeTypes() {
		InputStream qN4eGOna = null;
		extMimeTypes = new Properties();
		try {
			try {
				qN4eGOna = MimeUtil.class.getClassLoader()
						.getResourceAsStream("eu/medsea/mimeutil/mime-types.properties");
				if (qN4eGOna != null) {
					((Properties) extMimeTypes).load(qN4eGOna);
				}
			} catch (Exception Kald4ctV) {
				log.error("Error loading internal mime-types.properties", Kald4ctV);
			} finally {
				qN4eGOna = closeStream(qN4eGOna);
			}
			try {
				File u9KGQWm6 = new File(System.getProperty("user.home") + File.separator + ".mime-types.properties");
				if (u9KGQWm6.exists()) {
					qN4eGOna = new FileInputStream(u9KGQWm6);
					if (qN4eGOna != null) {
						log.debug("Found a custom .mime-types.properties file in the users home directory.");
						Properties Has7PVqb = new Properties();
						Has7PVqb.load(qN4eGOna);
						if (Has7PVqb.size() > 0) {
							extMimeTypes.putAll(Has7PVqb);
						}
						log.debug("Successfully parsed .mime-types.properties from users home directory.");
					}
				}
			} catch (Exception S7zy7PL6) {
				log.error("Failed to parse .magic.mime file from users home directory. File will be ignored.",
						S7zy7PL6);
			} finally {
				qN4eGOna = closeStream(qN4eGOna);
			}
			try {
				Enumeration X24cvcsM = MimeUtil.class.getClassLoader().getResources("mime-types.properties");
				while (X24cvcsM.hasMoreElements()) {
					URL lOenHtdL = (URL) X24cvcsM.nextElement();
					if (log.isDebugEnabled()) {
						log.debug("Found custom mime-types.properties file on the classpath [" + lOenHtdL + "].");
					}
					Properties iOLxoAgR = new Properties();
					try {
						qN4eGOna = lOenHtdL.openStream();
						if (qN4eGOna != null) {
							iOLxoAgR.load(qN4eGOna);
							if (iOLxoAgR.size() > 0) {
								extMimeTypes.putAll(iOLxoAgR);
								if (log.isDebugEnabled()) {
									log.debug("Successfully loaded custome mime-type.properties file [" + lOenHtdL
											+ "] from classpath.");
								}
							}
						}
					} catch (Exception NDfN3dVx) {
						log.error("Failed while loading custom mime-type.properties file [" + lOenHtdL
								+ "] from classpath. File will be ignored.");
					}
				}
			} catch (Exception WcWZfxKe) {
				log.error(
						"Problem while processing mime-types.properties files(s) from classpath. Files will be ignored.",
						WcWZfxKe);
			} finally {
				qN4eGOna = closeStream(qN4eGOna);
			}
			try {
				String csnQspPb = System.getProperty("mime-mappings");
				if (csnQspPb != null && csnQspPb.length() != 0) {
					qN4eGOna = new FileInputStream(csnQspPb);
					if (qN4eGOna != null) {
						if (log.isDebugEnabled()) {
							log.debug("Found a custom mime-mappings property defined by the property -Dmime-mappings ["
									+ System.getProperty("mime-mappings") + "].");
						}
						Properties pz34Gj0d = new Properties();
						pz34Gj0d.load(qN4eGOna);
						if (pz34Gj0d.size() > 0) {
							extMimeTypes.putAll(pz34Gj0d);
						}
						log.debug("Successfully loaded the mime mappings file from property -Dmime-mappings ["
								+ System.getProperty("mime-mappings") + "].");
					}
				}
			} catch (Exception xKmLZRi7) {
				log.error("Failed to load the mime-mappings file defined by the property -Dmime-mappings ["
						+ System.getProperty("mime-mappings") + "].");
			} finally {
				qN4eGOna = closeStream(qN4eGOna);
			}
		} finally {
			Iterator j9QnKLBv = extMimeTypes.values().iterator();
			while (j9QnKLBv.hasNext()) {
				String[] D3Nawwk0 = ((String) j9QnKLBv.next()).split(",");
				for (int cWhn7FAh = 0; cWhn7FAh < D3Nawwk0.length; cWhn7FAh++) {
					MimeUtil.addKnownMimeType(D3Nawwk0[cWhn7FAh]);
				}
			}
		}
	}

}