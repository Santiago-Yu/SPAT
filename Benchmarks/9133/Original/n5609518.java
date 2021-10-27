class n5609518{
    private void init() {
        synchronized (cachedProperties) {
            if (firstTime) {
                try {
                    Enumeration<URL> configFiles;
                    configFiles = classloader.getResources(CONFIG_LOCATION);
                    if (configFiles == null) {
                        logger.info("No configuration file ({}) found in the classpath.", CONFIG_LOCATION);
                        return;
                    }
                    firstTime = false;
                    boolean alreadyLoaded = false;
                    while (configFiles.hasMoreElements()) {
                        final URL url = configFiles.nextElement();
                        if (!alreadyLoaded) {
                            final InputStream is = url.openStream();
                            cachedProperties.load(is);
                            is.close();
                            logger.info("XmlFieldFactory configuration loaded from the file {}", url);
                        } else {
                            logger.info("An other XmlFieldFactory configuration file is found in the classpath. This file won't be loaded {}", url);
                        }
                    }
                } catch (IOException e) {
                    logger.error("An error occur during the XmlFieldFActory initialization", e);
                }
            }
        }
    }

}