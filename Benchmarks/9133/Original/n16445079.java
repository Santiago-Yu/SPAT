class n16445079{
    private static JvUndoableTableModel CSVReader(String filepath) throws IOException {
        try {
            URI url = new URI(filepath);
            return CSVReader(url.toURL().openStream());
        } catch (URISyntaxException ex) {
            File file = new File(filepath);
            return CSVReader(file);
        }
    }

}