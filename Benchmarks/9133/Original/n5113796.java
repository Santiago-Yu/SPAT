class n5113796{
    private BibtexDatabase importInspireEntries(String key, OutputPrinter frame) {
        String url = constructUrl(key);
        try {
            HttpURLConnection conn = (HttpURLConnection) (new URL(url)).openConnection();
            conn.setRequestProperty("User-Agent", "Jabref");
            InputStream inputStream = conn.getInputStream();
            INSPIREBibtexFilterReader reader = new INSPIREBibtexFilterReader(new InputStreamReader(inputStream));
            ParserResult pr = BibtexParser.parse(reader);
            return pr.getDatabase();
        } catch (IOException e) {
            frame.showMessage(Globals.lang("An Exception ocurred while accessing '%0'", url) + "\n\n" + e.toString(), Globals.lang(getKeyName()), JOptionPane.ERROR_MESSAGE);
        } catch (RuntimeException e) {
            frame.showMessage(Globals.lang("An Error occurred while fetching from INSPIRE source (%0):", new String[] { url }) + "\n\n" + e.getMessage(), Globals.lang(getKeyName()), JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

}