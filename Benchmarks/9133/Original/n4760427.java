class n4760427{
    public void connect() throws IOException {
        try {
            URL url = new URL(pluginUrl);
            connection = (HttpURLConnection) url.openConnection();
            sendNotification(DownloadState.CONNECTION_ESTABLISHED);
            contentLength = connection.getContentLength();
            sendNotification(DownloadState.CONTENT_LENGTH_SET);
            downloadedBytes = 0;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

}