class n15700614{
    public void open() throws IOException, RecursionException {
        String encoding = null;
        if (source != null) {
            Reader sourceReader = source.getCharacterStream();
            if (sourceReader != null) {
                if (readerReader == null) readerReader = new XMLReaderReader();
                readerReader.reset(sourceReader, true);
                isStandalone = readerReader.isXMLStandalone();
                activeReader = readerReader;
                isOpen = true;
                return;
            }
            InputStream in = source.getByteStream();
            if (in != null) {
                if (streamReader == null) streamReader = new XMLStreamReader();
                streamReader.reset(in, source.getEncoding(), true);
                isOpen = true;
                isStandalone = streamReader.isXMLStandalone();
                activeReader = streamReader;
                return;
            }
            url = new URL(defaultContext, source.getSystemId());
            sysID = url.toString();
            encoding = source.getEncoding();
        }
        if (streamReader == null) streamReader = new XMLStreamReader();
        streamReader.reset(url.openStream(), encoding, true);
        isStandalone = streamReader.isXMLStandalone();
        activeReader = streamReader;
        isOpen = true;
    }

}