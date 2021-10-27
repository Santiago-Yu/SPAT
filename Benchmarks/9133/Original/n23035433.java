class n23035433{
    public void read(final URL url) throws IOException, DataFormatException {
        final URLConnection connection = url.openConnection();
        final int fileSize = connection.getContentLength();
        if (fileSize < 0) {
            throw new FileNotFoundException(url.getFile());
        }
        final String mimeType = connection.getContentType();
        decoder = FontRegistry.getFontProvider(mimeType);
        if (decoder == null) {
            throw new DataFormatException("Unsupported format");
        }
        decoder.read(url);
    }

}