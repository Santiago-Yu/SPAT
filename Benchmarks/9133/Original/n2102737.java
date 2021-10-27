class n2102737{
    private String getContents(Server server, String uri) throws TechnicalException {
        try {
            URL url = new URL("http://localhost:" + PORT + uri);
            return StreamUtils.getStreamContent(url.openStream());
        } catch (Exception e) {
            e.printStackTrace();
            throw new TechnicalException(e);
        }
    }

}