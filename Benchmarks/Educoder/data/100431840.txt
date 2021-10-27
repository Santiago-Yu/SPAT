    public static void copyAll(URL url, Writer out) {
        Reader in = null;
        try {
            in = new InputStreamReader(new BufferedInputStream(url.openStream()));
            copyAll(in, out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            close(in);
        }
    }
