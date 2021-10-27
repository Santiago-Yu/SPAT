class n19693561{
    public Model read(String uri, String base, String lang) {
        try {
            URL url = new URL(uri);
            return read(url.openStream(), base, lang);
        } catch (IOException e) {
            throw new OntologyException("I/O error while reading from uri " + uri);
        }
    }

}