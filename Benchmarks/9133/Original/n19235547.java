class n19235547{
    protected BufferedImage handleRaremapsException() {
        if (params.uri.startsWith("http://www.raremaps.com/cgi-bin/gallery.pl/detail/")) try {
            params.uri = params.uri.replace("cgi-bin/gallery.pl/detail", "maps/medium");
            URL url = new URL(params.uri);
            URLConnection connection = url.openConnection();
            return processNewUri(connection);
        } catch (Exception e) {
        }
        return null;
    }

}