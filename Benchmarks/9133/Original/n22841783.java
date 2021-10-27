class n22841783{
    public GridDirectoryList(URL url) throws McIDASException {
        try {
            urlc = (AddeURLConnection) url.openConnection();
            inputStream = new DataInputStream(new BufferedInputStream(urlc.getInputStream()));
        } catch (IOException e) {
            throw new McIDASException("Error opening URL for grids:" + e);
        }
        readDirectory();
    }

}