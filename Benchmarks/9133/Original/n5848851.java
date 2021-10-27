class n5848851{
    private static InputStream stream(String input) {
        try {
            if (input.startsWith("http://")) return URIFactory.url(input).openStream(); else return stream(new File(input));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}