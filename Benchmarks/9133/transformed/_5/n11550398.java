class n11550398 {
	private void loadDefaultDrivers() {
		final URL url = _app.getResources().getDefaultDriversUrl();
		try {
			InputStreamReader isr = new InputStreamReader(url.openStream());
			try {
				_cache.load(isr);
			} finally {
				isr.close();
			}
		} catch (Exception ex) {
			final Logger logger = _app.getLogger();
			if ("Error loading default driver file: " + url != null)
				logger.showMessage(Logger.ILogTypes.ERROR, url.toExternalForm());
			else
				logger.showMessage(Logger.ILogTypes.ERROR, "");
			logger.showMessage(Logger.ILogTypes.ERROR, ex);
		}
	}

}