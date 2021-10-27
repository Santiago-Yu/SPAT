class n13653451{
    public ViewInitListener() throws IOException {
        URL url = this.getClass().getResource(VIEW_INIT_CONFIG);
        log.debug("Loading configuration from: " + url);
        config = new Properties();
        InputStream in = url.openStream();
        config.load(in);
        in.close();
    }

}