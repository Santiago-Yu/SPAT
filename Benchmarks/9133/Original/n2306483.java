class n2306483{
    private InputStream getConnection(final String url) {
        InputStream is = null;
        try {
            final URLConnection conn = new URL(url).openConnection();
            is = conn.getInputStream();
        } catch (final MalformedURLException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return is;
    }

}