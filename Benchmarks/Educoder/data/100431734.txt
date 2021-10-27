    public static HttpResponse createUrlResponse(final URL url, final TcpConnection connection) throws IOException, NullPointerException {
        String fullPath = url.toString();
        URLConnection conn = url.openConnection();
        InputStream in = conn.getInputStream();
        final long length = conn.getContentLength();
        if (connection.isDebugEnabled()) connection.logDebug("Sending " + fullPath + " to " + connection.getRemoteAddress() + " (length: " + length + ").");
        return createInputStreamResponse(in, conn.getContentType(), length, connection);
    }
