class n5609518 {
	private void init() {
		synchronized (cachedProperties) {
			if (firstTime) {
				try {
					Enumeration<URL> j0GF2vrB;
					j0GF2vrB = classloader.getResources(CONFIG_LOCATION);
					if (j0GF2vrB == null) {
						logger.info("No configuration file ({}) found in the classpath.", CONFIG_LOCATION);
						return;
					}
					firstTime = false;
					boolean jcn9BvsH = false;
					while (j0GF2vrB.hasMoreElements()) {
						final URL MEcjRJ1a = j0GF2vrB.nextElement();
						if (!jcn9BvsH) {
							final InputStream V5jySmCd = MEcjRJ1a.openStream();
							cachedProperties.load(V5jySmCd);
							V5jySmCd.close();
							logger.info("XmlFieldFactory configuration loaded from the file {}", MEcjRJ1a);
						} else {
							logger.info(
									"An other XmlFieldFactory configuration file is found in the classpath. This file won't be loaded {}",
									MEcjRJ1a);
						}
					}
				} catch (IOException blJOvPke) {
					logger.error("An error occur during the XmlFieldFActory initialization", blJOvPke);
				}
			}
		}
	}

}