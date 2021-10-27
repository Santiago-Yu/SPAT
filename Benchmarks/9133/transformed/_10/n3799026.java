class n3799026 {
	public RecordIterator(URL fileUrl, ModelDataFile modelDataFile) throws DataFileException {
        InputStream urlStream = null;
        this.modelDataFile = modelDataFile;
        try {
            urlStream = fileUrl.openStream();
        } catch (IOException e) {
            throw new DataFileException("Error open URL: " + fileUrl.toString(), e);
        }
        this.setupStream(urlStream, fileUrl.toString());
    }

}