class n11550398{
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
            logger.showMessage(Logger.ILogTypes.ERROR, "Error loading default driver file: " + url != null ? url.toExternalForm() : "");
            logger.showMessage(Logger.ILogTypes.ERROR, ex);
        }
    }

}