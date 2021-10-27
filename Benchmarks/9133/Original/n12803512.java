class n12803512{
    @Override
    public CheckAvailabilityResult execute(final CheckAvailabilityAction action, final ExecutionContext context) throws ActionException {
        if (LOGGER.isDebugEnabled()) {
            String serverName = null;
            if (action.getServerId() == CheckAvailability.FEDORA_ID) {
                serverName = "fedora";
            } else if (action.getServerId() == CheckAvailability.KRAMERIUS_ID) {
                serverName = "kramerius";
            }
            LOGGER.debug("Processing action: CheckAvailability: " + serverName);
        }
        ServerUtils.checkExpiredSession(httpSessionProvider);
        boolean status = true;
        String url = null;
        String usr = "";
        String pass = "";
        if (action.getServerId() == CheckAvailability.FEDORA_ID) {
            url = configuration.getFedoraHost();
            usr = configuration.getFedoraLogin();
            pass = configuration.getFedoraPassword();
        } else if (action.getServerId() == CheckAvailability.KRAMERIUS_ID) {
            url = configuration.getKrameriusHost() + SOME_STATIC_KRAMERIUS_PAGE;
        } else {
            throw new ActionException("Unknown server id");
        }
        try {
            URLConnection con = RESTHelper.openConnection(url, usr, pass, false);
            if (con instanceof HttpURLConnection) {
                HttpURLConnection httpConnection = (HttpURLConnection) con;
                int resp = httpConnection.getResponseCode();
                if (resp < 200 || resp >= 308) {
                    status = false;
                    LOGGER.info("Server " + url + " answered with HTTP code " + httpConnection.getResponseCode());
                }
            } else {
                status = false;
            }
        } catch (MalformedURLException e) {
            status = false;
            e.printStackTrace();
        } catch (IOException e) {
            status = false;
            e.printStackTrace();
        }
        return new CheckAvailabilityResult(status, url);
    }

}