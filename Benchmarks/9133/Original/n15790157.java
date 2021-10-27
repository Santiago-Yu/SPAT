class n15790157{
    public String runRawSearch(final String search) throws IOException {
        if (search == null) {
            return null;
        }
        StringBuilder urlString = new StringBuilder("http://ajax.googleapis.com/ajax/services/search/web?");
        if (version != null) {
            urlString.append("v=");
            urlString.append(version);
            urlString.append("&");
        }
        urlString.append("q=");
        urlString.append(StringEscapeUtils.escapeHtml(search));
        URL url = new URL(urlString.toString());
        Proxy proxy = null;
        final URLConnection connection;
        if (proxy != null) {
            connection = url.openConnection(proxy);
        } else {
            connection = url.openConnection();
        }
        if (referer != null) {
            connection.addRequestProperty("Referer", referer);
        }
        String line;
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }

}