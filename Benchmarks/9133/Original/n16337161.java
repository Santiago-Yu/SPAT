class n16337161{
    public String index(URL url) {
        InputStream is = null;
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setInstanceFollowRedirects(true);
            urlConnection.setAllowUserInteraction(false);
            System.setProperty("sun.net.client.defaultConnectTimeout", "15000");
            System.setProperty("sun.net.client.defaultReadTimeout", "15000");
            urlConnection.connect();
            is = urlConnection.getInputStream();
            return index(is);
        } catch (Throwable t) {
        } finally {
            IOUtils.closeQuietly(is);
        }
        return "";
    }

}