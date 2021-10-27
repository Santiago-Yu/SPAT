class n7952920{
    public static InputStream getInputStream(String path) throws ResourceException {
        URL url = getURL(path);
        if (url != null) {
            try {
                return url.openConnection().getInputStream();
            } catch (IOException e) {
                throw new ResourceException(e);
            }
        } else {
            throw new ResourceException("Error obtaining resource, invalid path: " + path);
        }
    }

}