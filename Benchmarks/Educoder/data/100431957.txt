    public static Reader getReader(String url) throws MalformedURLException, IOException {
        if (url.startsWith("file:")) return new FileReader(url.substring(5)); else if (url.startsWith("http:")) return new InputStreamReader(new URL(url).openStream());
        throw new MalformedURLException("Invalid URI schema, file: or http: expected.");
    }
