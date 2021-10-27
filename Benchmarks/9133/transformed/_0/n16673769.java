class n16673769 {
	@Override
	public void Start() {
		try {
			Enumeration<URL> RQeRzAWH = Configurator.class.getClassLoader()
					.getResources(IOCContainer.GetApplicationName() + ".config");
			while (RQeRzAWH.hasMoreElements()) {
				URL tC9uuiMt = RQeRzAWH.nextElement();
				if (Logger.logger.isDebugEnabled()) {
					Logger.logger.debug("Loading '" + tC9uuiMt + "'");
				}
				JSONValue a0RojujG = JSONValue.Decode(tC9uuiMt.openStream(), tC9uuiMt.toString());
				if (a0RojujG instanceof JSONObjectValue) {
					for (Configurable wzt8vc32 : IOCContainer.LookupAll(Configurable.class)) {
						JSONValue WTvigr7O = ((JSONObjectValue) a0RojujG).GetProperty(wzt8vc32.GetConfigSectionName());
						if (WTvigr7O != null) {
							if (Logger.logger.isDebugEnabled()) {
								Logger.logger
										.debug("Configurging " + wzt8vc32.getClass() + " with '" + WTvigr7O.Encode());
							}
							try {
								wzt8vc32.Configure(WTvigr7O);
							} catch (Throwable BrcXuvuI) {
								Logger.logger.error("Caught throwable while configuring " + wzt8vc32.getClass() + ":"
										+ BrcXuvuI.getMessage() + ". IGNORED.", BrcXuvuI);
								Logger.logger.error("[Continued]. Config Data was:" + WTvigr7O.Encode());
							}
						}
					}
				} else {
					Logger.logger.error("'" + tC9uuiMt
							+ "' does not contain a json object. Skipping and looking for other applciation.config files in classpath ...");
				}
			}
		} catch (Throwable vO17kOzY) {
			throw new RuntimeException(
					"Exception while attempting to load application.config:'" + vO17kOzY.getMessage() + "'", vO17kOzY);
		}
	}

}