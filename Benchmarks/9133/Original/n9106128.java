class n9106128{
    protected long getUrlSize(String location) {
        long returnValue = 0L;
        try {
            URL url = new URL(location);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
            conn.setRequestMethod("HEAD");
            returnValue = conn.getContentLength();
        } catch (IOException ioe) {
            logger.error("Failed to find proper size for entity at " + location, ioe);
        }
        return returnValue;
    }

}