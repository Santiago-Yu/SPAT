    public static ArrayList<String> loadURLToStrings(URL url, int maxLines, String userAgent, int timeout) throws IOException {
        URLConnection connection = url.openConnection();
        if (userAgent != null && userAgent.trim().length() > 0) {
            connection.setRequestProperty("User-Agent", userAgent);
        } else {
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; astrominer/1.0;)");
        }
        if (timeout > 0) {
            connection.setConnectTimeout(timeout);
        }
        connection.connect();
        return loadURLToStrings(connection, maxLines);
    }
