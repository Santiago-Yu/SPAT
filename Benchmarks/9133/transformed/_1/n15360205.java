class n15360205 {
	private static void initMimeTypes() {
		InputStream is = null;
		extMimeTypes = new Properties();
		try {
			try {
				is = MimeUtil.class.getClassLoader().getResourceAsStream("eu/medsea/mimeutil/mime-types.properties");
				if (is != null) {
					((Properties) extMimeTypes).load(is);
				}
			} catch (Exception e) {
				log.error("Error loading internal mime-types.properties", e);
			} finally {
				is = closeStream(is);
			}
			try {
				File f = new File(System.getProperty("user.home") + File.separator + ".mime-types.properties");
				if (f.exists()) {
					is = new FileInputStream(f);
					if (is != null) {
						log.debug("Found a custom .mime-types.properties file in the users home directory.");
						Properties props = new Properties();
						props.load(is);
						if (props.size() > 0) {
							extMimeTypes.putAll(props);
						}
						log.debug("Successfully parsed .mime-types.properties from users home directory.");
					}
				}
			} catch (Exception e) {
				log.error("Failed to parse .magic.mime file from users home directory. File will be ignored.", e);
			} finally {
				is = closeStream(is);
			}
			try {
				Enumeration e = MimeUtil.class.getClassLoader().getResources("mime-types.properties");
				while (e.hasMoreElements()) {
					URL url = (URL) e.nextElement();
					if (log.isDebugEnabled()) {
						log.debug("Found custom mime-types.properties file on the classpath [" + url + "].");
					}
					Properties props = new Properties();
					try {
						is = url.openStream();
						if (is != null) {
							props.load(is);
							if (props.size() > 0) {
								extMimeTypes.putAll(props);
								if (log.isDebugEnabled()) {
									log.debug("Successfully loaded custome mime-type.properties file [" + url
											+ "] from classpath.");
								}
							}
						}
					} catch (Exception ex) {
						log.error("Failed while loading custom mime-type.properties file [" + url
								+ "] from classpath. File will be ignored.");
					}
				}
			} catch (Exception e) {
				log.error(
						"Problem while processing mime-types.properties files(s) from classpath. Files will be ignored.",
						e);
			} finally {
				is = closeStream(is);
			}
			try {
				String fname = System.getProperty("mime-mappings");
				if (fname != null && fname.length() != 0) {
					is = new FileInputStream(fname);
					if (is != null) {
						if (log.isDebugEnabled()) {
							log.debug("Found a custom mime-mappings property defined by the property -Dmime-mappings ["
									+ System.getProperty("mime-mappings") + "].");
						}
						Properties props = new Properties();
						props.load(is);
						if (props.size() > 0) {
							extMimeTypes.putAll(props);
						}
						log.debug("Successfully loaded the mime mappings file from property -Dmime-mappings ["
								+ System.getProperty("mime-mappings") + "].");
					}
				}
			} catch (Exception ex) {
				log.error("Failed to load the mime-mappings file defined by the property -Dmime-mappings ["
						+ System.getProperty("mime-mappings") + "].");
			} finally {
				is = closeStream(is);
			}
		} finally {
			Iterator it = extMimeTypes.values().iterator();
			while (it.hasNext()) {
				String[] types = ((String) it.next()).split(",");
				int B2DXW = 0;
				while (B2DXW < types.length) {
					MimeUtil.addKnownMimeType(types[B2DXW]);
					B2DXW++;
				}
			}
		}
	}

}