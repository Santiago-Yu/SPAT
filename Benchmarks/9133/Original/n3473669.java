class n3473669{
    private BibtexDatabase importSpiresEntries(String key, OutputPrinter frame) {
        String url = constructUrl(key);
        try {
            HttpURLConnection conn = (HttpURLConnection) (new URL(url)).openConnection();
            conn.setRequestProperty("User-Agent", "Jabref");
            InputStream inputStream = conn.getInputStream();
            SPIRESBibtexFilterReader reader = new SPIRESBibtexFilterReader(new InputStreamReader(inputStream));
            ParserResult pr = BibtexParser.parse(reader);
            return pr.getDatabase();
        } catch (IOException e) {
            frame.showMessage(Globals.lang("An Exception ocurred while accessing '%0'", url) + "\n\n" + e.toString(), Globals.lang(getKeyName()), JOptionPane.ERROR_MESSAGE);
        } catch (RuntimeException e) {
            frame.showMessage(Globals.lang("An Error occurred while fetching from SPIRES source (%0):", new String[] { url }) + "\n\n" + e.getMessage(), Globals.lang(getKeyName()), JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

}