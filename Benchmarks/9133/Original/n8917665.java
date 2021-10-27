class n8917665{
    public static void copyAll(URL url, StringBuilder ret) {
        Reader in = null;
        try {
            in = new InputStreamReader(new BufferedInputStream(url.openStream()));
            copyAll(in, ret);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            close(in);
        }
    }

}