class n14757689{
    protected Collection<BibtexEntry> getBibtexEntries(String ticket, String citations) throws IOException {
        try {
            URL url = new URL(URL_BIBTEX);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Cookie", ticket + "; " + citations);
            conn.connect();
            BibtexParser parser = new BibtexParser(new BufferedReader(new InputStreamReader(conn.getInputStream())));
            return parser.parse().getDatabase().getEntries();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}