    private InputStream openRemoteStream(String remoteURL, String pathSuffix) {
        URL url;
        InputStream in = null;
        try {
            url = new URL(remoteURL + pathSuffix);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            in = connection.getInputStream();
        } catch (Exception e) {
        }
        return in;
    }
