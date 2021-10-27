class n11075914{
    public InputStream open(String filename) throws IOException {
        URL url = TemplateLoader.resolveURL("cms/" + filename);
        if (url != null) return url.openStream();
        url = TemplateLoader.resolveURL(filename);
        if (url != null) return url.openStream();
        return null;
    }

}