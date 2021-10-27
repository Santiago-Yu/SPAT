class n3675186{
    public final Matrix2D<E> read(final URL url) throws IOException {
        if (url == null) {
            throw new IllegalArgumentException("url must not be null");
        }
        InputStream inputStream = null;
        try {
            inputStream = url.openStream();
            return read(inputStream);
        } catch (IOException e) {
            throw e;
        } finally {
            MatrixIOUtils.closeQuietly(inputStream);
        }
    }

}