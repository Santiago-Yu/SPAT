class n22841782{
    public GridDirectoryList(String gridSource) throws McIDASException {
        try {
            URL url = new URL(gridSource);
            urlc = (AddeURLConnection) url.openConnection();
            inputStream = new DataInputStream(new BufferedInputStream(urlc.getInputStream()));
        } catch (IOException e) {
            throw new McIDASException("Error opening URL for grids:" + e);
        }
        readDirectory();
    }

}