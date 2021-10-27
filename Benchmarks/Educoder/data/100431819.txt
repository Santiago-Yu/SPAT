    @Override
    public Content getContent(Object principal, ContentPath path, Version version, Map<String, Object> properties) throws ContentException {
        String uniqueName = path.getBaseName();
        URL url = buildURL(uniqueName);
        URLContent content = new URLContent(url, this.getName(), uniqueName);
        content.setUniqueName(uniqueName);
        content.setReadable(true);
        content.setWritable(writable);
        content.setExists(true);
        try {
            URLConnection connection = url.openConnection();
            String mimeType = connection.getContentType();
            content.setMimeType(mimeType);
            content.setWritable(true);
        } catch (IOException ex) {
            throw new ContentException("unable to obtain mime type of " + url, ex);
        }
        return content;
    }
