class n12267657{
    public Reader create(final URI url) throws IOException {
        this.url = url;
        if (!url.isAbsolute()) {
            return new FileReader(new File(url.toString()));
        }
        URLConnection connection = url.toURL().openConnection();
        connection.setDoInput(true);
        final InputStream inputStream = connection.getInputStream();
        return new InputStreamReader(inputStream);
    }

}