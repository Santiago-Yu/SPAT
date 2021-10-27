class n3357695{
    public void readCatalog(Catalog catalog, String fileUrl) throws MalformedURLException, IOException, CatalogException {
        URL url = null;
        try {
            url = new URL(fileUrl);
        } catch (MalformedURLException e) {
            url = new URL("file:///" + fileUrl);
        }
        debug = catalog.getCatalogManager().debug;
        try {
            URLConnection urlCon = url.openConnection();
            readCatalog(catalog, urlCon.getInputStream());
        } catch (FileNotFoundException e) {
            catalog.getCatalogManager().debug.message(1, "Failed to load catalog, file not found", url.toString());
        }
    }

}