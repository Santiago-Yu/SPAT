class n14899091{
    protected long getURLLastModified(final URL url) throws IOException {
        final URLConnection con = url.openConnection();
        long lastModified = con.getLastModified();
        try {
            con.getInputStream().close();
        } catch (IOException ignored) {
        }
        return lastModified;
    }

}