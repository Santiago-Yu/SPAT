class n18036453{
    public static TikaInputStream get(URL url, Metadata metadata) throws IOException {
        if ("file".equalsIgnoreCase(url.getProtocol())) {
            try {
                File file = new File(url.toURI());
                if (file.isFile()) {
                    return get(file, metadata);
                }
            } catch (URISyntaxException e) {
            }
        }
        URLConnection connection = url.openConnection();
        String path = url.getPath();
        int slash = path.lastIndexOf('/');
        if (slash + 1 < path.length()) {
            metadata.set(Metadata.RESOURCE_NAME_KEY, path.substring(slash + 1));
        }
        String type = connection.getContentType();
        if (type != null) {
            metadata.set(Metadata.CONTENT_TYPE, type);
        }
        String encoding = connection.getContentEncoding();
        if (encoding != null) {
            metadata.set(Metadata.CONTENT_ENCODING, encoding);
        }
        int length = connection.getContentLength();
        if (length >= 0) {
            metadata.set(Metadata.CONTENT_LENGTH, Integer.toString(length));
        }
        return new TikaInputStream(new BufferedInputStream(connection.getInputStream()), new TemporaryResources(), length);
    }

}