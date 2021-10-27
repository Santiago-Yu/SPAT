    public InputStream openInput(Fragment path) throws IOException {
        int len = path.words().size();
        String p = Util.combine("/", path.words().subList(1, len));
        URL url = new URL("http", path.words().get(0), p);
        InputStream result = url.openStream();
        return result;
    }
