class n22422244{
    protected Source getStylesheetSource(Resource stylesheetLocation) throws ApplicationContextException {
        if (logger.isDebugEnabled()) {
            logger.debug("Loading XSLT stylesheet from " + stylesheetLocation);
        }
        try {
            URL url = stylesheetLocation.getURL();
            String urlPath = url.toString();
            String systemId = urlPath.substring(0, urlPath.lastIndexOf('/') + 1);
            return new StreamSource(url.openStream(), systemId);
        } catch (IOException ex) {
            throw new ApplicationContextException("Can't load XSLT stylesheet from " + stylesheetLocation, ex);
        }
    }

}