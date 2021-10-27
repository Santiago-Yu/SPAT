class n17742073{
    private HttpURLConnection getRecognizedUrl(SpantusAudioCtx ctx) throws URISyntaxException {
        try {
            URL url = ctx.getRecognizedUrl();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            return conn;
        } catch (MalformedURLException e) {
            LOG.error(e);
        } catch (IOException e) {
            LOG.error(e);
        }
        return null;
    }

}