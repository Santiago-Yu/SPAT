class n2479734{
    protected InputSource loadExternalSdl(String aActualLocation) throws RuntimeException {
        logger.debug("loadExternalSdl(String) " + aActualLocation);
        try {
            URL url = new URL(aActualLocation);
            return new InputSource(url.openStream());
        } catch (MalformedURLException e) {
            logger.error(e);
            throw new RuntimeException(aActualLocation + AeMessages.getString("AeWsdlLocator.ERROR_1"), e);
        } catch (IOException e) {
            logger.error(e);
            throw new RuntimeException(AeMessages.getString("AeWsdlLocator.ERROR_2") + aActualLocation, e);
        }
    }

}