    public static InputStream getConfigIs(String path, String name) throws ProgrammerException, DesignerException, UserException {
        InputStream is = null;
        try {
            URL url = getConfigResource(new MonadUri(path).append(name));
            if (url != null) {
                is = url.openStream();
            }
        } catch (IOException e) {
            throw new ProgrammerException(e);
        }
        return is;
    }
