class n10093209{
    @Override
    public InitResult init(String name) {
        this.urlString = name;
        URL url;
        URLConnection con;
        try {
            url = new URL(urlString);
            con = url.openConnection();
            int size = con.getContentLength();
            char[] characters = new char[size];
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            in.read(characters);
            in.close();
            return new InitResult(0, size, characters);
        } catch (Exception e) {
            throw new ParserException(e);
        }
    }

}