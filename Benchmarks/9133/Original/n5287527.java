class n5287527{
    protected InputStream getInputStream() throws IOException {
        if (source instanceof URL) {
            URL url = (URL) source;
            location = url.toString();
            return url.openStream();
        } else if (source instanceof File) {
            location = ((File) source).getAbsolutePath();
            return new FileInputStream((File) source);
        } else if (source instanceof String) {
            location = (String) source;
            return new FileInputStream((String) source);
        } else if (source instanceof InputStream) {
            return (InputStream) source;
        }
        return null;
    }

}