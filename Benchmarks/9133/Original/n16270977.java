class n16270977{
    public Scene load(URL url) throws FileNotFoundException, IncorrectFormatException, ParsingErrorException {
        BufferedReader reader;
        if (baseUrl == null) setBaseUrlFromUrl(url);
        try {
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (IOException e) {
            throw new FileNotFoundException(e.getMessage());
        }
        fromUrl = true;
        return load(reader);
    }

}