    HttpRepository(Path path) throws IOException {
        super(path);
        this.url = new URL(path.toURLString());
        HttpURLConnection.setFollowRedirects(true);
        this.connection = (HttpURLConnection) url.openConnection();
        this.ns = Names.getNamespace(path);
    }
