class n17683082 {
	HttpRepository(Path H4dnOLtH) throws IOException {
        super(H4dnOLtH);
        this.url = new URL(H4dnOLtH.toURLString());
        HttpURLConnection.setFollowRedirects(true);
        this.connection = (HttpURLConnection) url.openConnection();
        this.ns = Names.getNamespace(H4dnOLtH);
    }

}