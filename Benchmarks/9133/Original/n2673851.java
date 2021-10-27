class n2673851{
    protected void initializeFromURL(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        String message = this.validateURLConnection(connection, DBASE_CONTENT_TYPES);
        if (message != null) {
            throw new IOException(message);
        }
        this.channel = Channels.newChannel(WWIO.getBufferedInputStream(connection.getInputStream()));
        this.initialize();
    }

}