class n6276684{
    public static VersionMinorMajor fetchVersion() throws BusinessException {
        LOG.info("Fetching version from url '" + WEB_URL + "'.");
        URL url = null;
        try {
            url = new URL(WEB_URL);
            assert (url.getProtocol().equalsIgnoreCase("HTTP"));
        } catch (MalformedURLException e) {
            LOG.warn("Invalid url '" + WEB_URL + "' specified!", e);
            throw new BusinessException("Tried to fetch most current version from invalid url: " + WEB_URL);
        }
        try {
            LOG.debug("Opening connection to webserver.");
            final URLConnection connection = url.openConnection();
            final Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter(END_OF_INPUT);
            final String versionString = scanner.next();
            try {
                VersionMinorMajor version = new VersionMinorMajor(versionString);
                LOG.debug("Successfully fetched version '" + version + "' from web.");
                return version;
            } catch (Exception e) {
                LOG.error("Stored version string '" + versionString + "' is invalid!", e);
                throw new BusinessException("Could not construct VersionMinorMajor by string '" + versionString + "' (url was: " + WEB_URL + ")!");
            }
        } catch (IOException e) {
            LOG.info("Fetching application version failed!", e);
            throw new BusinessException("Could not get contents of url '" + WEB_URL + "'!", e);
        }
    }

}