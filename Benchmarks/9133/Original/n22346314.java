class n22346314{
    public URLConnection makeURLcon() {
        URI uri;
        URL url;
        try {
            uri = new URI(this.URLString);
            url = uri.toURL();
            this.urlcon = (HttpURLConnection) url.openConnection();
        } catch (final URISyntaxException e) {
            e.printStackTrace();
        } catch (final MalformedURLException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return this.urlcon;
    }

}