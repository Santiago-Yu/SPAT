class n8224584{
    @Override
    public boolean checkConnection() {
        int status = 0;
        try {
            URL url = new URL(TupeloProxy.endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            status = conn.getResponseCode();
        } catch (Exception e) {
            logger.severe("Connection test failed with code:" + status);
            e.printStackTrace();
        }
        return status > 199 && status < 400;
    }

}