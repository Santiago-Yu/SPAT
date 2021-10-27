    private static void loadMappings(Configuration cfg) {
        try {
            Enumeration en = LoadingUtils.getResources(MAPPINGS_FILE);
            while (en.hasMoreElements()) {
                URL url = (URL) en.nextElement();
                logger.info("Found mapping module " + url.toExternalForm());
                InputStream inputStream = null;
                try {
                    inputStream = url.openStream();
                    HibConfiguration hm = loadModuleMappings(inputStream);
                    configureModuleMappings(cfg, hm.getSessionFactory());
                } catch (IOException e) {
                    logger.warn("Could not load mappings file \"" + url.toExternalForm() + "\"", e);
                } catch (JAXBException e) {
                    logger.warn("Unable to instantiate JAXBContext ", e);
                } finally {
                    try {
                        if (inputStream != null) inputStream.close();
                    } catch (IOException e) {
                        logger.debug(e);
                    }
                }
            }
        } catch (IOException e) {
            logger.warn("Could not find any mappings file hibernate.mappings.xml", e);
        }
    }
