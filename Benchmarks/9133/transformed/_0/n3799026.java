class n3799026 {
	public RecordIterator(URL UWNXatO9, ModelDataFile KQHAETUB) throws DataFileException {
        this.modelDataFile = KQHAETUB;
        InputStream hB10TAA6 = null;
        try {
            hB10TAA6 = UWNXatO9.openStream();
        } catch (IOException NQNIPcuP) {
            throw new DataFileException("Error open URL: " + UWNXatO9.toString(), NQNIPcuP);
        }
        this.setupStream(hB10TAA6, UWNXatO9.toString());
    }

}