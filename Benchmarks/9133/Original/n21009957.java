class n21009957{
    @Override
    public void readMessages(final Messages messages) throws LocatorException {
        try {
            final InputStream in = url.openStream();
            try {
                final Properties properties = new Properties();
                properties.load(in);
                messages.add(locale, properties);
            } finally {
                in.close();
            }
        } catch (final IOException e) {
            throw new LocatorException("Failed to read messages from URL: " + url, e);
        }
    }

}