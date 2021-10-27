class n3799026{
    public RecordIterator(URL fileUrl, ModelDataFile modelDataFile) throws DataFileException {
        this.modelDataFile = modelDataFile;
        InputStream urlStream = null;
        try {
            urlStream = fileUrl.openStream();
        } catch (IOException e) {
            throw new DataFileException("Error open URL: " + fileUrl.toString(), e);
        }
        this.setupStream(urlStream, fileUrl.toString());
    }

}