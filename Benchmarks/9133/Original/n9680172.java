class n9680172{
    public HttpURLConnection openConnection(String url) throws IOException {
        if (isDebugMode()) System.out.println("open: " + url);
        URL u = new URL(url);
        HttpURLConnection urlConnection;
        if (proxy != null) urlConnection = (HttpURLConnection) u.openConnection(proxy); else urlConnection = (HttpURLConnection) u.openConnection();
        urlConnection.setRequestProperty("User-Agent", userAgent);
        return urlConnection;
    }

}