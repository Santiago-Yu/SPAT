class n22841783 {
	public GridDirectoryList(URL dbcvUNWU) throws McIDASException {
        try {
            urlc = (AddeURLConnection) dbcvUNWU.openConnection();
            inputStream = new DataInputStream(new BufferedInputStream(urlc.getInputStream()));
        } catch (IOException y1dxYwe8) {
            throw new McIDASException("Error opening URL for grids:" + y1dxYwe8);
        }
        readDirectory();
    }

}