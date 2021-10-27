    @Override
    public void Start() {
        try {
            Enumeration<URL> resources = Configurator.class.getClassLoader().getResources(IOCContainer.GetApplicationName() + ".config");
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                if (Logger.logger.isDebugEnabled()) {
                    Logger.logger.debug("Loading '" + url + "'");
                }
                JSONValue configFileContents = JSONValue.Decode(url.openStream(), url.toString());
                if (configFileContents instanceof JSONObjectValue) {
                    for (Configurable configurable : IOCContainer.LookupAll(Configurable.class)) {
                        JSONValue jsonData = ((JSONObjectValue) configFileContents).GetProperty(configurable.GetConfigSectionName());
                        if (jsonData != null) {
                            if (Logger.logger.isDebugEnabled()) {
                                Logger.logger.debug("Configurging " + configurable.getClass() + " with '" + jsonData.Encode());
                            }
                            try {
                                configurable.Configure(jsonData);
                            } catch (Throwable th1) {
                                Logger.logger.error("Caught throwable while configuring " + configurable.getClass() + ":" + th1.getMessage() + ". IGNORED.", th1);
                                Logger.logger.error("[Continued]. Config Data was:" + jsonData.Encode());
                            }
                        }
                    }
                } else {
                    Logger.logger.error("'" + url + "' does not contain a json object. Skipping and looking for other applciation.config files in classpath ...");
                }
            }
        } catch (Throwable th) {
            throw new RuntimeException("Exception while attempting to load application.config:'" + th.getMessage() + "'", th);
        }
    }
